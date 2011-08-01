import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.Type
import java.util.Locale

object BenchmarkTester {
	def main(args: Array[String]) {
		val total = 67108864 // 2^26
	    var inputs = new Array[Int](total)
		println("Populating list of inputs...")
		for (i <- 0 until total) { //test every number from 0 to total
			inputs(i) = i
		}
		
		/* Uncomment the test(s) you want to run */
		println("Benchmarking using Array input...")
		print("Duration of divideByTwo: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.divideByTwo(_), inputs) + "ms\n")
		print("Duration of recursiveDivideByTwo: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.recursiveDivideByTwo(_), inputs) + "ms\n")
		print("Duration of checkAll: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.checkAll(_), inputs) + "ms\n")
		print("Duration of checkNextPower: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.checkNextPower(_), inputs) + "ms\n")
		print("Duration of linearSearch: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.linearSearch(_), inputs) + "ms\n")
		print("Duration of binarySearch: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.binarySearch(_), inputs) + "ms\n")
		print("Duration of countOnes: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.countOnes(_), inputs) + "ms\n")
		print("Duration of shiftRight: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.shiftRight(_), inputs) + "ms\n")
		print("Duration of decrementAndCompare: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.decrementAndCompare(_), inputs) + "ms\n")

		
		println("Benchmarking using Generated input...")
		print("Duration of divideByTwo: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.divideByTwo(_), (i: Int) => i, total) + "ms\n")
		print("Duration of recursiveDivideByTwo: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.recursiveDivideByTwo(_), (i: Int) => i, total) + "ms\n")
		print("Duration of checkAll: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.checkAll(_), (i: Int) => i, total) + "ms\n")
		print("Duration of checkNextPower: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.checkNextPower(_), (i: Int) => i, total) + "ms\n")
		print("Duration of linearSearch: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.linearSearch(_), (i: Int) => i, total) + "ms\n")
		print("Duration of binarySearch: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.binarySearch(_), (i: Int) => i, total) + "ms\n")
		print("Duration of countOnes: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.countOnes(_), (i: Int) => i, total) + "ms\n")
		print("Duration of shiftRight: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.shiftRight(_), (i: Int) => i, total) + "ms\n")
		print("Duration of decrementAndCompare: ")
		print(Benchmarker.benchmark[Int, Boolean](IsPowerOfTwo.decrementAndCompare(_), (i: Int) => i, total) + "ms\n")
	}
}