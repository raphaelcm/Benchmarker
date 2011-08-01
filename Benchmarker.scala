import compat.Platform

object Benchmarker {

	/** 
	 * Measure the performance of one function f over an array of inputs. 
	 * Method is genericized for input and output types of f. 
	 *
	 * Usage:
	 *   Benchmarker.benchmark[T, R](f[Function1], inputs[Array])
	 *
	 * @param f Function1 ((T) => R)
	 * @param inputs Array[T]
	 * @return elapsed time in milliseconds (Long)
	 */
	def benchmark[T, R](f: (T) => R, inputs: Array[T]): Long = {
		val l1 = Platform.currentTime
		for(i <- 0 until inputs.length) f(inputs(i))
		val l2 = Platform.currentTime
		Platform.collectGarbage
		
		return l2 - l1
	}

	/** 
	 * Measure the performance of one function f over a list of inputs. 
	 * Method is genericized for input and output types of f. 
	 *
	 * Usage:
	 *   Benchmarker.benchmark[T, R](f[Function1], inputs[List])
	 *
	 * @param f Function1 ((T) => R)
	 * @param inputs List[T]
	 * @return elapsed time in milliseconds (Long)
	 */
	def benchmark[T, R](f: (T) => R, inputs: List[T]): Long = {
		val inputsIterator = inputs.iterator
		val l1 = Platform.currentTime
		
		while(inputsIterator.hasNext) f(inputsIterator.next)
		
		val l2 = Platform.currentTime
		Platform.collectGarbage
		
		return l2 - l1
	}

	/** 
	 * TO DO: Measure the performance of one function f over a delimited input file. 
	 * Method is genericized for input and output types of f. 
	 *
	 * Usage:
	 *   Benchmarker.benchmark[T, R](f[Function1], TODO)
	 *
	 * @param f Function1 ((T) => R)
	 * @param inputs TODO
	 * @return elapsed time in milliseconds (Long)
	 */
	/* TODO - Data File Input
	def benchmark[T, R](f: (T) => R, inputs: TODO): Long = {
		val l1 = System.currentTimeMillis
		val inputsIterator = inputs.iterator
		
		while(inputsIterator.hasNext) f(inputsIterator.next)
		
		return System.currentTimeMillis - l1
	}
	*/

	/** 
	 * Measure the performance of a function over generated inputs g(0) to g(n) 
	 *
	 * Usage:
	 *   Benchmarker.benchmark[T, R](f[Function1], generator[Function1], iterations[Int])
	 * 
	 * @param f Function1 ((T) => R)
	 * @param generator Function1 ((Int) => T)
	 * @param iterations number of times to run f on generator output
	 * @return Long (elapsed time in ms)
	 */
	def benchmark[T, R](f: (T) => R, generator: (Int) => T, iterations: Int): Long = {
		val l1 = Platform.currentTime
		
		for(i <- 0 until iterations) f(generator(i))
		
		val l2 = Platform.currentTime
		Platform.collectGarbage
		
		return l2 - l1
	}
}