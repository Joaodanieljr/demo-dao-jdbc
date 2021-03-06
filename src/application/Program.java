package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
	
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller FindById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Teste 2: seller FindByDepartment ====");
		Department dep = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj : list ){
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: seller FindByDepartment ====");
		list = sellerDao.findAll();
		for(Seller obj : list ){
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4 : seller insert ====");
		Seller newSeller = new Seller(null, "joao", "joaodaniel@uol.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("new ID: " + newSeller.getId());
		
		System.out.println("\n=== Teste 5 : seller insert ====");
		seller = sellerDao.findById(3);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Teste 6 : seller insert ====");
		Integer id = 1;
		sellerDao.deletById(id);
		System.out.println("Delete completed");
	}

}
