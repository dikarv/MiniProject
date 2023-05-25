# mini_project
Spring Boot Framework

#save wallet
method POST
localhost:8070/wallets
Request Body JSON format
{
    "phoneNumber" : "081xxxxxxxxx",
    "balance" : "1000.0"
}

#find-all
method GET 
localhost:8070/wallets

#debit-wallet
method POST
Request Params
localhost:8070/debit?phoneNumber=081xxxxxxxxx&amount=10000.0

#topup-wallet
method POST
Request Params
localhost:8070/topup?topup=25000&phone=081xxxxxxxxx


This application is a mini project from
the payment method uses an API using the postgres database and the Java programming language with the Spring Boot framework

Thank you
