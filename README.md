# YahooFinance
Yahoo Finance API - A Springboot application for displaying stock quotes in real time and calculating the average price of watched stocks.

Steps to run:
1. It is a simple straight forward maven project import into IDE. 
2. After doing Maven build, you can go to Main application which is FinanceApplication.java and right click -> Run As -> Java Application.
3. Application will run as a Springboot application and it will run in your local machine with localhost port typically 8080.

Please run below urls for the API: 
To display all the stock quotes - {localhost url}/finance/stock/quotes/
To retrieve only a specific stock quote - {localhost url}/finance/stock/quotes/{stockName} which is for example -> {localhost url}/finance/stock/quotes/INTC
To add a specific stock to a watched stocks - {localhost url}/finance/stock/quotes/add/{stockName} which is for example -> {localhost url}/finance/stock/quotes/add/INTC
To remove a specific stock from a watched stocks - {localhost url}/finance/stock/quotes/remove/{stockName} which is for example -> {localhost url}/finance/stock/quotes/remove/INTC
To view all the watched stock quotes - {localhost url}/finance/stock/quotes/watchList
To get average price of watched stocks - {localhost url}/finance/stock/quotes/avgprice
