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
### ✅ A Solução: Injeção de Dependência ###
Para resolver isso, deve-se usar uma <b>Interface</b> como contrato, para que a Classe PaymentProcess passe a aceitar outros meios de pagamento.
````
@contract
public interface PaymentMethod {
    void pay(String name, double value, int installment);
}
````
````
@Concretes
public class CreditCardService implements PaymentMethod {
    @Override
    public void pay(String name, double value, int installment) {
        System.out.printf("Payment by %s, value of $ %.2f in %d installments.%n", name, value, installment);
    }
}

public class PixService implements PaymentMethod {
    @Override
    public void pay(String name, double value, int installment) {
        System.out.println("Payment '%s' by Pix, value of R$ %.2f in %d installments.%n", name, value, installment);
    }
}
````
````
@Client
public class  {
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
        PaymentMethod pix1 = new PixService();

        PaymentProcess payment1 = new PaymentProcess(card1);
        payment1.execute("Visa", 350.75, 3);

        PaymentProcess payment2 = new PaymentProcess(pix1);
        payment2.execute("Pix", 49.90, 1)
    }
}
````
<br>

### ⚠️ Pontos fracos: Um desacoplamento ainda rígido ###
Por mais que o problema de 'aceitar mais meios de pagamento sem alterar a Classe' tenha sido resolvido, nota-se que o sistema ainda está um pouco rígido. Ele ainda obriga <b>todos os sistemas a terem a mesma quantidade de parâmetros</b>, fazendo a Classe <b>Pix</b> fornecer dados irrelevanges 