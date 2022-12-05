package Lezione6;

public class BancaAccount  {
	double saldo;
	String nome;
	int numcc;
	Banca account = new Banca();
	
	BancaAccount(double saldo,String nome,int numcc){
	this.saldo=saldo;
	this.nome=nome;
	this.numcc=numcc;
	}
	
	void deposito(double sommaDep) {
		
	}
	void prelievo(double sommaDep) {
		
	}
	double getSaldo() {
		return saldo;
	}
	double getName() {
		return saldo;
	}
	double getNumCC() {
		return saldo;
	}
	
}
