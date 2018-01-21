package metier.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Compte;
import metier.session.IBanqueLocal;
@Stateless
@WebService
public class BanqueService {
	@EJB
private IBanqueLocal metier;
	@WebMethod
public void addCompte(@WebParam(name="solde")double soldeInitial){
	Compte cp=new Compte(soldeInitial, new Date(),true);
	metier.addCompte(cp);	
}
	@WebMethod
public List<Compte> listComptes(){
	return metier.getAllComptes();	
}
	@WebMethod
public Compte getCompte(@WebParam(name="code")Long code){
	return metier.getCompte(code);	
}
	@WebMethod
public void verser(@WebParam(name="montant")double mt,@WebParam(name="code") Long code){
	metier.verser(mt, code);	
}
	@WebMethod
public void retirer(@WebParam(name="montant")double mt,@WebParam(name="code") Long code){
	metier.retirer(mt, code);	
}
	@WebMethod
public void virement(@WebParam(name="montant")double mt,@WebParam(name="code1") Long c1,@WebParam(name="code2") Long c2){
	metier.virement(mt, c1, c2);	
}
	//http://localhost:8080/EJB_Banque/BanqueService?wsdl
}
