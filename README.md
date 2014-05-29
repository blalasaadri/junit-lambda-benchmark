junit-lambda-benchmark
======================

This is a micro benchmark for parallel testing using the junit-lambda library.

Test setup
----------

The test was run on an Early 2013 MacBook Pro.

- CPU: 2.4 GHz Intel Core i7 (4 cores, 8 threads)
- L2-Cache/core: 256 KB
- L3-Cache: 6MB
- RAM: 2x4GB 1600 MHz DDR3
- Graphicscard: Intel HD Graphics 4000 512 MB
- OS: Mac OS X 1.8.5

Results
-------

Running on the above Laptop, the final output was as follows:

> Run complete. Total time: 04:49:09
> 
> <table>
>	<tr>
>		<td>Benchmark</td>
>		<td>Mode</td>
>		<td>Samples</td>
>		<td>Mean</td>
>		<td>Mean error</td>
>		<td>Units</td>
>	</tr><tr>
>		<td>c.s.ParallelTestingBenchmark.parallelTests</td>
>		<td>thrpt</td>
>		<td>100</td>
>		<td>8,811</td>
>		<td>0,022</td>
>		<td>ops/min</td>
>	</tr><tr>
>		<td>c.s.ParallelTestingBenchmark.sequentialTests</td>
>		<td>thrpt</td>
>		<td>100</td>
>		<td>4,103</td>
>		<td>0,006</td>
>		<td>ops/min</td>
>	</tr>
> </table>

Anyone is welcome to download the code to replicate the results or (since it is published under the MIT licence) do pretty much anything else with it.
