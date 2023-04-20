package application;

import java.util.Date;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
						
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST2: seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller objSeller : list) {		
			System.out.println(objSeller);
		}
				
		System.out.println("\n=== TEST3: seller findAll ===");
		
		list = sellerDao.findAll();
		for (Seller objSeller : list) {		
			System.out.println(objSeller);
		}
		
		System.out.println("\n=== TEST4: seller Insert ===");
		
		Seller newseller = new Seller (null,"Greg", "greg@gmail.com", new Date(), 4000.0, department);
		
		sellerDao.insert(newseller);
		
		System.out.println("Inserted! New Id =" + newseller.getId());

		System.out.println("\n=== TEST5: seller Update ===");

		seller = sellerDao.findById(1);
		seller.setName("Marta");
		
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST6: seller Delete ===");

				
		sellerDao.deleteById(11);
		System.out.println("Delete completed");
		
		
		
	}

}
