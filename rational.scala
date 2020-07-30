object rationalQ{

	class Rational(x: Int, y: Int){ //classes should start with capital as it is the norm (e.g. - String, Int, Double... etc.)
		private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
		private val g = gcd(x, y);
		
		private var numer = x / g;
		private var denom = y / g;
		
		//In case the denominator is negative, let's fix that
		if (denom < 0){
			numer *= -1; //Multiply both by negative :D
			denom *= -1;
		}
		
		def neg = new Rational(-this.numer, this.denom);
		
		def +(r: Rational) = new Rational(this.numer * r.denom + r.numer * this.denom, this.denom * r.denom);
		
		def -(r: Rational) = this + r.neg;
		
		override def toString = numer.toString + "/" + denom.toString;
	}
	
	def main(args: Array[String]): Unit = {
		val x = new Rational(3, 4);
		val y = new Rational(5, 8);
		val z = new Rational(2, 7);
		
		val res = x-y-z;
		printf("%s\n", res.toString);
	}
	
}