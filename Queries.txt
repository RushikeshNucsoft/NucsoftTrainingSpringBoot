CREATE TABLE DedupeEngineNitin.dbo.Bank (
	Bank_ID int NOT NULL,
	Bank_Name nvarchar(50) NOT NULL,
	Bank_Code nvarchar(50) NOT NULL,
	Bank_Address nvarchar(50) NOT NULL
);

INSERT INTO DedupeEngineNitin.dbo.Bank
(Bank_ID, Bank_Name, Bank_Code, Bank_Address)
VALUES(1, 'HDFC', '01', 'Mumbai');

INSERT INTO DedupeEngineNitin.dbo.Bank
(Bank_ID, Bank_Name, Bank_Code, Bank_Address)
VALUES(2, 'SBI', '02', 'Mumbai');

INSERT INTO DedupeEngineNitin.dbo.Bank
(Bank_ID, Bank_Name, Bank_Code, Bank_Address)
VALUES(3, 'CANARA', '03', 'Mumbai');

INSERT INTO DedupeEngineNitin.dbo.Bank
(Bank_ID, Bank_Name, Bank_Code, Bank_Address)
VALUES(4, 'BankOfMaharashtra', '04', 'Mumbai');

ALTER TABLE Bank
ADD CONSTRAINT PK_Bank PRIMARY KEY (Bank_ID);

CREATE TABLE DedupeEngineNitin.dbo.Branch (
	Branch_ID int NOT NULL,
	Branch_Name nvarchar(50) NOT NULL,
	Branch_Code nvarchar(50) NOT NULL,
	Branch_Address nvarchar(50) NOT NULL,
	Bank_Name nvarchar(50) NOT NULL,
	Bank_ID int NOT NULL
);

ALTER TABLE Branch
ADD CONSTRAINT PK_Branch PRIMARY KEY (Branch_ID);

ALTER TABLE Branch
ADD CONSTRAINT FK_Branch_Bank
FOREIGN KEY (Bank_ID) REFERENCES Bank(Bank_ID);

INSERT INTO DedupeEngineNitin.dbo.Branch
(Branch_ID, Branch_Name, Branch_Code, Branch_Address, Bank_Name, Bank_ID)
VALUES(10, 'Mulund', '100', 'Mulund', 'HDFC', 1);

INSERT INTO DedupeEngineNitin.dbo.Branch
(Branch_ID, Branch_Name, Branch_Code, Branch_Address, Bank_Name, Bank_ID)
VALUES(20, 'Andheri', '200', 'Andheri', 'HDFC', 1);

INSERT INTO DedupeEngineNitin.dbo.Branch
(Branch_ID, Branch_Name, Branch_Code, Branch_Address, Bank_Name, Bank_ID)
VALUES(30, 'Lalbag', '300', 'Lalbag', 'HDFC', 1);

INSERT INTO DedupeEngineNitin.dbo.Branch
(Branch_ID, Branch_Name, Branch_Code, Branch_Address, Bank_Name, Bank_ID)
VALUES(100, 'Mulund', '100', 'Mulund', 'SBI', 2);









CREATE TABLE DedupeEngineNitin.dbo.Bank_Customer (
	Customer_ID int NOT NULL,
	Customer_Name nvarchar(50) NOT NULL,
	Customer_Phone nvarchar(50) NOT NULL,
	Customer_Address nvarchar(50) NOT NULL,
	Branch_Name nvarchar(50) NOT NULL,
	Branch_ID int NOT NULL,
	Bank_Name nvarchar(50) NOT NULL,
	Bank_ID nvarchar(50) NOT NULL,
);

ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer
ADD Loan_ID INT,
FOREIGN KEY (Loan_ID) REFERENCES Loan(Loan_ID);

ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer
ALTER COLUMN Bank_ID INT;

ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer
ADD CONSTRAINT PK_Customer PRIMARY KEY (Customer_ID);

ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer
ADD CONSTRAINT FK_Bank_Customer_Branch
FOREIGN KEY (Branch_ID) REFERENCES Branch(Branch_ID);


ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer
ADD CONSTRAINT FK_Bank_Customer_Bank
FOREIGN KEY (Bank_ID) REFERENCES Bank(Bank_ID);

ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer DROP CONSTRAINT FK_Bank_Customer_Bank;
ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer DROP CONSTRAINT FK_Bank_Customer_Branch;
ALTER TABLE DedupeEngineNitin.dbo.Bank_Customer DROP CONSTRAINT FK__Bank_Cust__Loan___29E1370A;


INSERT INTO DedupeEngineNitin.dbo.Bank_Customer
(Customer_ID, Customer_Name, Customer_Phone, Customer_Address, Branch_Name, Branch_ID, Bank_Name, Bank_ID)
VALUES(004, 'Rushikesh', '9969409040', 'Mulund', 'Mulund', 60, 'CANARA', 3);

CREATE TABLE Account (
    Account_No INT PRIMARY KEY,
    Account_Type NVARCHAR(50),
    Balance DECIMAL(18, 2),
   Customer_ID int NOT NULL,
  Branch_ID int NOT NULL,
  Bank_ID int NOT NULL)
 ;

ALTER TABLE Account
ADD CONSTRAINT FK_Account_Customer
FOREIGN KEY (Customer_ID) REFERENCES Bank_Customer(Customer_ID);


ALTER TABLE Account
ADD CONSTRAINT FK_Account_Branch
FOREIGN KEY (Branch_ID) REFERENCES Branch(Branch_ID);


ALTER TABLE Account
ADD CONSTRAINT FK_Account_Bank
FOREIGN KEY (Bank_ID) REFERENCES Bank(Bank_ID);

INSERT INTO DedupeEngineNitin.dbo.Account
(Account_No, Account_Type, Balance, Customer_ID, Branch_ID, Bank_ID)
VALUES(1111, 'Saving', 40000, 1, 60, 3);


CREATE TABLE Loan (
    Loan_ID INT PRIMARY KEY,
    Loan_Type NVARCHAR(50),
    Amount DECIMAL(18, 2),
    Customer_ID INT
);

INSERT INTO DedupeEngineNitin.dbo.Loan
(Loan_ID, Loan_Type, Amount, Customer_ID)
VALUES(600, 'Personal', 500000, 5);

ALTER TABLE DedupeEngineNitin.dbo.Loan
ADD CONSTRAINT FK_Loan_Customer FOREIGN KEY (Customer_ID) REFERENCES DedupeEngineNitin.dbo.Bank_Customer(Customer_ID);

ALTER TABLE DedupeEngineNitin.dbo.Loan
ADD Bank_ID int NULL,
CONSTRAINT FK_Loan_Bank FOREIGN KEY (Bank_ID) REFERENCES DedupeEngineNitin.dbo.Bank(Bank_ID);

ALTER TABLE DedupeEngineNitin.dbo.Loan
DROP CONSTRAINT FK_Loan_Bank;

ALTER TABLE DedupeEngineNitin.dbo.Loan
ALTER COLUMN Bank_ID int NULL;

INSERT INTO DedupeEngineNitin.dbo.Loan (Loan_ID, Loan_Type, Amount, Customer_ID, Bank_ID)
VALUES (800, 'PersonalLoan', 5000.00, 1, 1),
       (900, 'HomeLoan', 100000.00, 2, 1),
       (1000, 'CarLoan', 20000.00, 3, 1);

      ALTER TABLE DedupeEngineNitin.dbo.Loan
ADD CONSTRAINT FK_Loan_Bank FOREIGN KEY (Bank_ID) REFERENCES DedupeEngineNitin.dbo.Bank(Bank_ID);




























