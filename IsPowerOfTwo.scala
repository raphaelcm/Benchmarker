/*

Scala implementation of several methods for determining if an integer is a power of two.

Adapted from http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/

*/

object IsPowerOfTwo {
	def divideByTwo(x: Int): Boolean = {
		var test = x;
		while (((test % 2) == 0) && test > 1) {
			test = test / 2
		}
		return (test == 1)
	}

	def recursiveDivideByTwo(x: Int): Boolean = {
		if (((x % 2) == 0) && x > 1) return divideByTwo(x / 2)
		else return (x == 1)
	}

	def checkAll(x: Int): Boolean = {
		return (x == 1 || x == 2 || x == 4 || x == 8 || x == 16 || x == 32 || x == 64 || x == 128 || x == 256 || x == 512 || x == 1024 ||x == 2048 || x == 4096 || x == 8192 || x == 16384 || x == 32768 || x == 65536 || x == 131072 || x == 262144 || x == 524288 || x == 1048576 || x == 2097152 || x == 4194304 || x == 8388608 || x == 16777216 || x == 33554432 || x == 67108864 || x == 134217728 || x == 268435456 || x == 536870912 || x == 1073741824)
	}


	def checkNextPower(x: Int): Boolean = {
		var powerOfTwo = 1

		while (powerOfTwo < x && powerOfTwo < 1073741824) {
			powerOfTwo *= 2
		}
		return (x == powerOfTwo)
	}


	def linearSearch(x: Int): Boolean = {
		val powersOfTwo = Array(1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824)

		var exponent = 0

		while (powersOfTwo(exponent) < x && exponent < 31) {
			exponent += 1
		}
		return (x == powersOfTwo(exponent))
	}

	def binarySearch(x: Int): Boolean = {
		val powersOfTwo = Array(1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824)
		var isAPowerOfTwo = false
		var interval = 16
		var exponent = interval /* Start out at midpoint */ 

		if(x == 0) return false
		if(x == 1) return true

		while (x != powersOfTwo(exponent) && interval > 1) {
			if (x < powersOfTwo(exponent)) exponent -= interval/2
			else exponent -= interval/2
			interval /= 2
		}
		isAPowerOfTwo = x == powersOfTwo(exponent);

		return (isAPowerOfTwo);
	}

	def countOnes(x: Int): Boolean = {
		var numberOfOneBits = 0
		var input = x

		while(input > 0 && numberOfOneBits <=1)
		{
			if ((input & 1) == 1) numberOfOneBits = numberOfOneBits + 1
			input = input >> 1          /* Shift number one bit to the right */
		}

		return (numberOfOneBits == 1) /* 'True' if only one 1 bit */
	}

	def shiftRight(x: Int): Boolean = {
		var input = x
		while (((input & 1) == 0) && input > 1) input = input >> 1
		return (input == 1);
	}

	def decrementAndCompare(x: Int): Boolean = {
		return ((x != 0) && !((x & (x - 1))!=0))
	}
}
