-- ============================================
-- Zombies Ate My Database
-- Release the Zombies 🧟🧟‍♀️🧟‍
--
-- WARNING:
-- Every INSERT has a chance to unleash a zombie.
-- Victims are chosen at random. Good luck.
-- ============================================

CREATE TABLE IF NOT EXISTS zombie_outbreak_config (
    config_id INTEGER PRIMARY KEY CHECK (config_id = 1),
    doctor_name VARCHAR(100) NOT NULL,
    credential_number INTEGER NOT NULL,
    outbreak_enabled BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO zombie_outbreak_config (
    config_id,
    doctor_name,
    credential_number,
    outbreak_enabled
)
VALUES (1, 'Dr.Tongue', 993, TRUE)
ON CONFLICT (config_id) DO NOTHING;

CREATE OR REPLACE FUNCTION zombie_eats_character()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
DECLARE
    eaten_character_name VARCHAR(50);
BEGIN
    -- The trigger reads the current cure credentials from the configuration table.
    IF EXISTS (
        SELECT 1
        FROM zombie_outbreak_config
        WHERE config_id = 1
          AND LOWER(doctor_name) = LOWER(NEW.name)
          AND credential_number = NEW.hp
    ) THEN
        UPDATE zombie_outbreak_config
        SET outbreak_enabled = FALSE
        WHERE config_id = 1;

        RAISE NOTICE
            '🧬 The cure was released! The outbreak is gone.';
        RETURN NEW;
    END IF;

    -- Once the cure is active, inserts continue normally without zombie attacks.
    IF NOT EXISTS (
        SELECT 1
        FROM zombie_outbreak_config
        WHERE config_id = 1
          AND outbreak_enabled = TRUE
    ) THEN
        RETURN NEW;
    END IF;

    IF random() < 0.30 THEN
        DELETE FROM character
        WHERE id = (
            SELECT id
            FROM character
            WHERE id <> NEW.id
            ORDER BY random()
            LIMIT 1
        )
        RETURNING name INTO eaten_character_name;

        IF eaten_character_name IS NOT NULL THEN
            RAISE NOTICE
                '🧟 A zombie ate % from the database!!!', eaten_character_name;
        END IF;
    END IF;

    RETURN NEW;
END;
$$;

DROP TRIGGER IF EXISTS zombie_attack ON character;

CREATE TRIGGER zombie_attack
AFTER INSERT ON character
FOR EACH ROW
EXECUTE FUNCTION zombie_eats_character();
