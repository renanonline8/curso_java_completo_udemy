package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Demonstração de domínio Pessoa iniciada...");
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("secao-25-jpa-maven");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		System.out.println("Adicionado pessoas a tabela...");
		
		Pessoa p = em.find(Pessoa.class, p2.getId());
		System.out.println("Localizado pessoa: " + p + "...");
		
		em.remove(p);
		System.out.println("Removido a pessoa localizada...");
		
		em.getTransaction().commit();
		
		System.out.println("Demonstração de domínio Pessoa concluída!");
	}

}
