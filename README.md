# MoneyTransfer

1) PJA and hibernate were used for the project since they provide fast development from classes to database.
   The application.properties file contains the database connection details and includes the data definition 
   language properties for the database. Update was selected to create/update the database objects
2) Customer is linked to one or more accounts. This is denoted accordingly by the annotations
3) AccountService provides the definition of the methods that need to be implemented and AccountServiceRepository
   is used for the implementation. AccountServiceRepository uses the AccountRepository which contains the standard
   CRUD (create,read, update, delete) methods. For the MoneyTransfer method @Transactional is used cause so in case
   any of the methods fails, data is rolled back.
4) Exceptions are also implemented for the different exceptions that can occur. Mainly an account not being found
   and an account does not have sufficient balance to withdraw money.