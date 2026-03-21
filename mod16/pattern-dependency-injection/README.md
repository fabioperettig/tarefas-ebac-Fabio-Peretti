# Pattern - Injeção de Dependência #

Uma Injeção de Dependência (DI) é um padrão de projeto que possibilita remover o acoplamento rígido entre classes, permitindo que um objeto receba suas dependências de uma fonte externa em vez de criá-las internamente.

### ❌ O Problema: Acoplamento Rígido (Sem DI) ###
No exemplo abaixo, a classe <b>PaymentProcess</b> cria sua própria dependência com a classe <b>CreditCard</b>.

````
public class CreditCard {
    
    public void pay(String flag, double value, int installment) {
        System.out.printf("Payment by %s, value of $ %.2f in %d installments.%n", flag, value, installment);
    }
}
````
````
public class PaymentProcess {
    
    private CreditCard service = new CreditCard();

    public void process(double value) {
        service.pay("Visa", value, 2); 
    }
}
````
<b>Por que isso é ruim?</b>
Se o cliente quiser fazer o pagamento via Pix, a Classe terá que ser alterada com uma nova intanciação e um novo método deverá ser implementado.
<br><br>
### ☑️ A Solução: Injeção de Dependência ###
Para resolver isso, deve-se usar uma <b>Interface</b> como contrato, para que a Classe PaymentProcess passe a aceitar outros meios de pagamento.
````
@contract
public interface PaymentMethod {
    void pay(String name, double value, int installment);
}
````
````
//Concretes
public class CreditCardService implements PaymentMethod {
    @Override
    public void pay(String name, double value, int installment) {
        System.out.printf("Payment by %s, value of $ %.2f in %d installments.%n", name, value, installment);
    }
}

public class PixService implements PaymentMethod {
    @Override
    public void pay(String name, double value, int installment) {
        System.out.printf("Payment '%s' by Pix, value of R$ %.2f in %d installments.%n", name, value, installment);
    }
}
````
````
//Client
public class PaymentProcess{
    private final PaymentMethod paymentMethod;

    public PaymentProcess(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void execute(String name, double value, int installment) {
        paymentMethod.pay(name, value, installment);
    }
}
````
````
public class Main {
    public static void main(String[] args) {


        PaymentMethod card1 = new CreditCardService();
        PaymentMethod card2 = new CreditCardService();
        PaymentMethod card3 = new CreditCardService();
        
        PaymentMethod pix1 = new PixService();
        PaymentMethod pix2 = new PixService();
        PaymentMethod pix2 = new PixService();

        /// payments

        PaymentProcess pcard1 = new PaymentProcess(card1);
        pcard1.execute("Visa", 350.75, 3);

        PaymentProcess pcard2 = new PaymentProcess(card2);
        pcard2.execute("MasterCard", 150.00, 1);

        PaymentProcess pcard3 = new PaymentProcess(card3);
        pcard3.execute("Cielo", 1270.90, 10);

        PaymentProcess pixpay1 = new PaymentProcess(pix1);
        pixpay1.execute("Pix", 49.90, 1);

        PaymentProcess pixpay2 = new PaymentProcess(pix2);
        pixpay2.execute("Pix", 15.70, 1);

        PaymentProcess pixpay3 = new PaymentProcess(pix3);
        pixpay3.execute("Pix", 120.00, 1);
    }
}
````

### ⚠️ Pontos fracos: Um desacoplamento ainda rígido ###
Por mais que o problema de 'aceitar mais meios de pagamento sem alterar a Classe' tenha sido resolvido, nota-se que o sistema ainda está um pouco rígido. Ele ainda obriga <b>todos os sistemas a terem a mesma quantidade de parâmetros</b>, fazendo a Classe <b>Pix</b> fornecer dados irrelevantes ou repetitivos.
<br><br>

## ✅ A real solução: Injeção via Construtores ##
Esta sim é uma forma eficiente de DI. Você passa as configurações específicas de cada Classe (como a Bandeira e Parcelas) no momento em que cria o objeto, <b>e não no método de execução</b>. Assim, é possível organizar o projeto de uma melhor forma:

- O que varia por método: Vai para o Construtor da classe concreta.
- O que é comum a todos: Vai para a Interface.

````
//Contract
public interface PaymentMethod {
    void pay(double value); 
}
````
````
//Concretes
public class CreditCardService implements PaymentMethod {
    private String flag;
    private int installments;

    //ctor
    public CreditCardService(String flag, int installments) {
        this.flag = flag;
        this.installments = installments;
    }

    @Override
    public void pay(double value) {
        System.out.printf("Cartão %s: R$ %.2f em %dx%n", flag, value, installments);
    }
}

public class PixService implements PaymentMethod {
    @Override
    public void pay(double value) {
        System.out.printf("Pix: R$ %.2f", value);
    }
}
````
````
//Client
public class PaymentProcess {
    private final PaymentMethod paymentMethod;

    public PaymentProcess(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void execute(double value) {
        paymentMethod.pay(value);
    }
}
````
Desta forma, o projeto fica completamente livre de dependências, a Classe PaymentProcess não precisa saber de nenhuma infromação preestabelecida, apenas chamar o método <b>service.pay(value)</b>.

E assim, a Classe Main fica ainda mais simples, chamando o mesmo método para quaisquer tipos de pagamento.

````
public class Main {
    public static void main(String[] args) {
        
        PaymentMethod card1 = new CreditCardService("Visa", 3);
        PaymentMethod card2 = new CreditCardService("MasterCard", 1);
        PaymentMethod card3 = new CreditCardService("Cielo", 10);

        PaymentMethod pix1 = new PixService();
        PaymentMethod pix2 = new PixService();
        PaymentMethod pix3 = new PixService();

        /// payments

        PaymentProcess pcard1 = new PaymentProcess(card1);
        pcard1.execute(350.75);

        PaymentProcess pcard2 = new PaymentProcess(card2);
        pcard2.execute(150.00);

        PaymentProcess pcard3 = new PaymentProcess(card3);
        pcard3.execute(1270.90);

        PaymentProcess pixpay1 = new PaymentProcess(pix1);
        pixpay1.execute(49.90);

        PaymentProcess pixpay2 = new PaymentProcess(pix2);
        pixpay2.execute(15.70);

        PaymentProcess pixpay3 = new PaymentProcess(pix3);
        pixpay3.execute(120.00);
    }
}
````
<br>
Desta forma, fica evidente a vantagem e a robustez de um projeto desenhado via o padrão Injeção de Depedência (DI), excluíndo qualquer verborragia e focando do que realmente deixa o projeto funcional.

@Author Fabio Peretti Guimarães
📘 Projeto EBAC – Módulo: Padrões de Projeto 002
🗓️ Março de 2026