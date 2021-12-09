//package com.infosys.infymarket.user;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.infosys.infymarket.user.dto.RecipeDTO;
////import com.infosys.infymarket.user.dto.SellerDTO;
//import com.infosys.infymarket.user.entity.Recipe;
//
//import com.infosys.infymarket.user.exception.RecipeException;
//import com.infosys.infymarket.user.repository.RecipeRepository;
//import com.infosys.infymarket.user.service.RecipeService;
//
////@RunWith(SpringRunner.class)
//
//@SpringBootTest
////public class UserMicroserviceApplicationTests {
//
////	@Test
////	public void contextLoads() {
////	}
//	//@Mock
//	//RecipeRepository buyerRepository;
//	//@Mock
//	//SellerRepository sellerRepository;
//	//@InjectMocks
//	//RecipeService buyerService = new RecipeService();
//	//@InjectMocks
//	//SellerService sellerService = new SellerService();
//
//	// Test for valid data
//	@Test
//	public void authenticateBuyerValid() throws RecipeException {
//		List<Recipe> buyerList = new ArrayList<Recipe>();
//
//		Recipe buyerEntity = new Recipe();
//		buyerEntity.setBuyerid("B100");
//		buyerEntity.setEmail("madhuri@gmail.com");
//		buyerEntity.setName("Madhuri");
//		buyerEntity.setPassword("Madhu@123");
//		buyerEntity.setPhoneno("9009009001");
//		buyerEntity.setIsprivileged(true);
//		buyerEntity.setIsactive(true);
//		buyerEntity.setRewardpoints(20000);
//
//		buyerList.add(buyerEntity);
//
//		Mockito.when(buyerRepository.findAll()).thenReturn(buyerList);
//		List<RecipeDTO> rePlans = buyerService.getAllBuyer();
//		Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
//	}
//
//	// Test for Invalid data
//	@Test
//	public void authenticateBuyerInvalid() throws RecipeException {
//		List<Recipe> buyerList = new ArrayList<Recipe>();
//
//		Recipe buyerEntity = new Recipe();
////		buyerEntity.setBuyerid("B10");
////		buyerEntity.setEmail("madhuri@gmail");
////		buyerEntity.setName("Madhuri");
////		buyerEntity.setPassword("Madhu@123");
////		buyerEntity.setPhoneno("9009009001");
////		buyerEntity.setIsprivileged(true);
////		buyerEntity.setIsactive(true);
////		buyerEntity.setRewardpoints(20000);
//
//		buyerEntity.setBuyerid("B10");
//		buyerEntity.setEmail("madhuri");
//		buyerEntity.setName("Madhi");
//		buyerEntity.setPassword("adhu@123");
//		buyerEntity.setPhoneno("909009001");
//		buyerEntity.setIsprivileged(true);
//		buyerEntity.setIsactive(true);
//		buyerEntity.setRewardpoints(20000);
//		
//		buyerList.add(buyerEntity);
//		Optional opt = Optional.of(buyerEntity);// Valid
//
//		Optional opt1 = Optional.empty();// Invalid
//
//		Mockito.when(buyerRepository.findById(Mockito.anyString())).thenReturn(opt1);
//
////		Mockito.when(buyerRepository.findAll()).thenReturn(buyerList);
//		List<RecipeDTO> rePlans = buyerService.getAllBuyer();
//		Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
//	}
//
//	@Test
//	public void authenticateSellerValid() throws RecipeException {
//		List<Seller> sellerList = new ArrayList<Seller>();
//
//		Seller sellerEntity = new Seller();
//		sellerEntity.setSellerid("1");
//		sellerEntity.setEmail("madhuri@gmail.com");
//		sellerEntity.setName("Madhuri");
//		sellerEntity.setPassword("Madhu@123");
//		sellerEntity.setPhoneno("7007007001");;
//		sellerEntity.setIsactive(true);
//
//		sellerList.add(sellerEntity);
//
//		Mockito.when(sellerRepository.findAll()).thenReturn(sellerList);
//		List<SellerDTO> rePlans = sellerService.getAllSeller();
//		Assertions.assertEquals(rePlans.isEmpty(), sellerList.isEmpty());
//	}
//	
//	@Test
//	public void authenticateSellerInValid() throws RecipeException {
//		List<Seller> sellerList = new ArrayList<Seller>();
//
//		Seller sellerEntity = new Seller();
//		sellerEntity.setSellerid("123");
//		sellerEntity.setEmail("madhuri@gmail.com");
//		sellerEntity.setName("Madhuri");
//		sellerEntity.setPassword("Madhu@123");
//		sellerEntity.setPhoneno("7007007001");;
//		sellerEntity.setIsactive(true);
//
//		Optional opt = Optional.of(sellerEntity);// Valid
//
//		Optional opt1 = Optional.empty();// Invalid
//
//		Mockito.when(buyerRepository.findById(Mockito.anyString())).thenReturn(opt);
//
//		Mockito.when(sellerRepository.findAll()).thenReturn(sellerList);
//		List<SellerDTO> rePlans = sellerService.getAllSeller();
//		Assertions.assertEquals(rePlans.isEmpty(), sellerList.isEmpty());
//	}
//	
////	@Test
////	public void authenticateBuyerByIdValid() throws InfyMarketException {
//////		List<Buyer> buyerList = new ArrayList<Buyer>();
////
////		Buyer buyerEntity = new Buyer();
////		String id = buyerEntity.getBuyerid();
////
//////		buyerList.add(buyerEntity);
////
////		Mockito.when(buyerRepository.findById()).thenReturn(buyerList);
////		List<BuyerDTO> rePlans = buyerService.getAllBuyer();
////		Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
//		
////		Buyer buyers = new Buyer();
////		buyers.setBuyerid("B100");
////		
////		Mockito.when(buyerRepository.findById("B100")).thenReturn(buyers);
////		BuyerDTO actual = buyerService.getBuyerById("B100");
////		Assertions.assertEquals("SUCCESS", actual);
////	}
//	
//}
