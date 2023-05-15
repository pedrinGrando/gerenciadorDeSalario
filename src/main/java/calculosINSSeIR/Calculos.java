package calculosINSSeIR;

public class Calculos {

	public double calcularINSS(double salario) {
        double desconto = 0;

        if (salario <= 1693.72) {
            desconto = salario * 0.08;
        } else if (salario <= 2822.90) {
            desconto = salario * 0.09;
        } else if (salario <= 5645.80) {
            desconto = salario * 0.11;
        } else {
            desconto = 621.04;
        }
        return desconto;
    }
	
	public double calcularIR(double salario) {
		double desconto = 0;
		double mensal = 0;
		
		if (salario <= 1903.98) {
			desconto = 0;
		} else if(salario >= 1903.99 && salario <= 2826.65) {
			desconto = salario * 0.75;
		}else if (salario >= 3751.06 && salario >= 4664.68) {
			desconto = salario * 0.225;
		} else {
			desconto = salario * 0.275;
		}		
		
		mensal = desconto/12;
		
		return mensal;
	}

}
