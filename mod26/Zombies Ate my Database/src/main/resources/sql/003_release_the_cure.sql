-- ============================================
-- Zombies Ate My Database
-- Release the cure 🧬🧪🧬
--
-- UPDATE DATA:
-- A new cure was found to stop the apocalypse.
-- The zombies was gone and everything is fine.
-- For now...
-- ============================================

UPDATE zombie_outbreak_config
SET outbreak_enabled = FALSE
WHERE config_id = 1;

-- The trigger remains installed, but zombie attacks are ignored while
-- outbreak_enabled is FALSE.
-- UPDATE zombie_outbreak_config
-- SET outbreak_enabled = TRUE
-- WHERE config_id = 1;
