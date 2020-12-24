# msaccessAccount

1.Install ucanaccess dependency manually and add the UcanAccess Hibernate Dialect class in the classpath for accessing MS Access database.
2. Change the path of jdbc url t the acc.db path.
3. Build and Run the Application.

# Security Configuration
1. Users and Admin can access accounts/{accountID}
2. Admin members only can access advanced filtering with query parameters check accounts/{accountID}/filter, add query parameters for date range and amount range(optional, leave blank).
