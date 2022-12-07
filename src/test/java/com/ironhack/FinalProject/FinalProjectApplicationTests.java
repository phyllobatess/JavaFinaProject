package com.ironhack.FinalProject;

import com.ironhack.FinalProject.models.Accounts.*;
import com.ironhack.FinalProject.models.Users.*;
import com.ironhack.FinalProject.repositories.AccountsRepositories.CheckingRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.CreditCardRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.SavingsRepository;
import com.ironhack.FinalProject.repositories.AccountsRepositories.StudentCheckingRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AccountHoldersRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.AdminsRepository;
import com.ironhack.FinalProject.repositories.UserRepositories.ThirdPartyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class CreateObjectsTests {

	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	CreditCardRepository creditCardRepository;
	@Autowired
	SavingsRepository savingsRepository;
	@Autowired
	StudentCheckingRepository studentCheckingRepository;
	
	@Autowired 
	AccountHoldersRepository accountHoldersRepository;
	
	@Autowired
	AdminsRepository adminsRepository;
	
	@Autowired
	ThirdPartyRepository thirdPartyRepository;
	

	
	
	Checking checking1;
	Checking checking2;

	CreditCard creditcard1;
	CreditCard creditcard2;

	Savings savings1;
	Savings savings2;

	StudentChecking studentChecking1;
	StudentChecking studentChecking2;
	
	AccountHolders accountHolders1;
	AccountHolders accountHolders2;
	
	Admins admins1;
	Admins admins2;
	
	ThirdParty thirdParty1;
	ThirdParty thirdParty2;
	

	@BeforeEach
	void setUp(){

		accountHolders1=new AccountHolders("Ramon","123","ram", LocalDate.now(),new Address("Valencia 554",23343,"SP"),new Address("Aragó 43",23333,"SP"));
		accountHolders2=new AccountHolders("Igor","123","ig", LocalDate.now(),new Address("Valencia 552",23343,"SP"),new Address("Balmes 42",23333,"SP"));
		accountHoldersRepository.save(accountHolders1);
		accountHoldersRepository.save(accountHolders2);

		checking1=new Checking(new BigDecimal(232),accountHolders1,accountHolders2,new BigDecimal(2.03),"XXYY",new BigDecimal(23),new BigDecimal(232),LocalDate.now(), Status.ACTIVE);
		checking2=new Checking(new BigDecimal(232),accountHolders2,accountHolders1,new BigDecimal(2.443),"YYXX",new BigDecimal(23),new BigDecimal(232),LocalDate.now(), Status.FROZEN);
		checkingRepository.save(checking1);
		checkingRepository.save(checking2);

		studentChecking1=new StudentChecking(new BigDecimal(12.11),accountHolders1,accountHolders2,new BigDecimal(12.2),"XYY",LocalDate.now(),Status.ACTIVE);
		studentChecking2=new StudentChecking(new BigDecimal(12.11),accountHolders2,accountHolders1,new BigDecimal(12.2),"XYY",LocalDate.now(),Status.ACTIVE);
		studentCheckingRepository.save(studentChecking1);
		studentCheckingRepository.save(studentChecking2);

		savings1=new Savings(new BigDecimal(2),accountHolders1,accountHolders2,new BigDecimal(43),"ss",0.4,LocalDate.now(),Status.FROZEN);
		savings2=new Savings(new BigDecimal(2),accountHolders2,accountHolders1,new BigDecimal(44),"fffg",0.1,LocalDate.now(),Status.ACTIVE);
		savingsRepository.save(savings1);
		savingsRepository.save(savings2);

		creditcard1=new CreditCard(new BigDecimal(23.2),accountHolders1,accountHolders2,new BigDecimal(0.4),new BigDecimal(0.5),0.4);
		creditcard2=new CreditCard(new BigDecimal(45.2),accountHolders2,accountHolders1,new BigDecimal(0.2),new BigDecimal(0.5),0.4);
		creditCardRepository.save(creditcard1);
		creditCardRepository.save(creditcard2);


		admins1=new Admins("Rms","34324df","Ramon");
		admins2=new Admins("XSA","34324df","Luis");
		adminsRepository.save(admins1);
		adminsRepository.save(admins2);

		thirdParty1=new ThirdParty("SSS","dds","ss","#1#");
		thirdParty2=new ThirdParty("SSS","dds","ss","#2#");
		thirdPartyRepository.save(thirdParty1);
		thirdPartyRepository.save(thirdParty2);

	}

	@AfterEach
	void tearDown(){

		checkingRepository.deleteAll();
		accountHoldersRepository.deleteAll();
		creditCardRepository.deleteAll();
		savingsRepository.deleteAll();
		studentCheckingRepository.deleteAll();
		adminsRepository.deleteAll();
		thirdPartyRepository.deleteAll();
	}

	@Test
	void shouldCreateCheckingAccount_OK(){
		Assertions.assertEquals(2,checkingRepository.findAll().size());
	}

	@Test
	void shouldCreateStudentCheckingAccount_OK(){
		Assertions.assertEquals(2,studentCheckingRepository.findAll().size());
	}

	@Test
	void shouldCreateSavingsAccount_OK(){
		Assertions.assertEquals(2,savingsRepository.findAll().size());
	}


	@Test
	void shouldCreateCreditCardAccount_OK(){
		Assertions.assertEquals(2,creditCardRepository.findAll().size());
	}

	@Test
	void shouldCreateAccountHolder_OK(){
		Assertions.assertEquals(2,accountHoldersRepository.findAll().size());
	}


	@Test
	void shouldCreateAdmin_OK(){
		Assertions.assertEquals(2,adminsRepository.findAll().size());
	}

	@Test
	void shouldCreateThirdParty_OK(){
		Assertions.assertEquals(2,thirdPartyRepository.findAll().size());
	}

	@Test void shouldLimitInterestRate(){
		savings1=new Savings(new BigDecimal("2"),accountHolders1,accountHolders2,new BigDecimal(2),"AA",0.51,LocalDate.now(),Status.ACTIVE);
		Assertions.assertEquals(0.0025,savings1.getInterestRate());
		savings1=new Savings(new BigDecimal("2"),accountHolders1,accountHolders2,new BigDecimal(2),"AA",-0.2,LocalDate.now(),Status.ACTIVE);
		Assertions.assertEquals(0.0025,savings1.getInterestRate());

	}

}
