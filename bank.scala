object bankQ{
	
	class Account(id: String, num: Int, bal: Double){
		 private val nic: String = id;
		 private val accNum: Int = num;
		 private var accBalance: Double = bal;
		 
		 def getNIC = this.nic;
		 def getAccNum = this.accNum;
		 def getAccBalance = this.accBalance;
		 
		 def deposit(am: Double) = this.accBalance = this.accBalance + am;
		 def withdraw(am: Double) = this.accBalance = this.accBalance - am;
		 def transfer(that: Account, am: Double) = {this.withdraw(am); that.deposit(am);}
		 override def toString = nic + " : " + accNum.toString + " : Rs." + accBalance.toString;
		
	
	}

	def main(args: Array[String]): Unit = {
		
		val a1 = new Account("982648912V", 147039, 134.5);
		val a2 = new Account("941143041V", 238191, 432.75);
		printf("Account A1 = %s\nAccount A2 = %s\n\n", a1.toString, a2.toString);
		printf("Transfer Rs.200 from A2 to A1:\n");
		a2.transfer(a1, 200);
		printf("\t%s\n\t%s\n", a1.toString, a2.toString);
		
		//This list will be used repeatedly to test the functions
		var bank:List[Account] = List(
			new Account("982648912V", 147039, 134.5),
			new Account("941143041V", 238191, 432.75),
			new Account("222026122V", 256532, -32.75),
			new Account("587809797V", 242714, 1432.90),
			new Account("833820807V", 252683, -500.23),
			new Account("426705516V", 213830, 15000)
		);
		//Bank functions
		val overdraft = (b: List[Account]) => b.filter(x => x.getAccBalance < 0);
		val balanceSum = (b: List[Account]) => b.reduce((x, y) => new Account("Total Balance", 999999, x.getAccBalance + y.getAccBalance));
		val interest = (b: List[Account]) => b.map(x => if (x.getAccBalance < 0) new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.1)) else new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.05)));
		
		printf("\nBank functions will be tested on this list of accounts;\n\t%s\n", bank.mkString("\n\t"));
		printf("\nResult after filtering overdraft accounts;\n\t%s\n", overdraft(bank).mkString("\n\t"));
		printf("\nResult after calculating total balance;\n\t%s\n", balanceSum(bank).toString);		
		printf("\nResult after applying interest;\n\t%s\n", interest(bank).mkString("\n\t"));
		
	}

}