README file of project jalgorithm
Build Status:

![Build Status](https://travis-ci.org/sk1418/jalgorithm.svg?branch=master)


## Introduction

Some classic algorithm implemented in Java with demos. (only CLI available)

## Start
todo


	java -jar xxx.jar
	
### Implemented algorithms and demos so far:

	Available Demos:
	=============================================================================
	Comparison Sort                          |Sorting in linear time                  
	_____________________________________________________________________________
	   1 Heap Sort                           |  11 Bubble Sort                        
	   2 Insertion Sort                      |  12 Bucket Sort                        
	   3 Merge Sort                          |  13 Counting Sort                      
	   4 Merge(Optimized) Sort               |  14 Radix Sort                         
	   5 Quick Sort                          |                                        
	   6 Quick(Randomized) Sort              |                                        
	   7 ~> Compare Sort algorithms <~       |                                        
	=============================================================================
	Single LinkedList Problem
	_____________________________________________________________________________
	 100 Add two numbers                     | 106 Remove all dups Nodes From List    
	 101 Determine Circle in List            | 107 Reverse List                       
	 102 Find Circle Begin Node              | 108 Reverse every K nodes in List      
	 103 Least Recently Used (LRU) cache     | 109 Sort List                          
	 104 Remove Dups From Sorted List        | 110 Swap List Nodes in pair            
	 105 Remove N-th Node From End           |                                        
	=============================================================================
	Problems
	_____________________________________________________________________________
	 200 Build Tree from Pair List           | 212 Median Of Two Sorted Arrays        
	 201 Check Palindrome Number             | 213 Merge 2 Sorted Arrays              
	 202 Check Palindrome String             | 214 Plus One                           
	 203 Count Inversion Pairs in Array      | 215 Print Num in Alphabet Ord          
	 204 Find All Subsets                    | 216 Print Rest Array In Range          
	 205 Find Heavy Integers                 | 217 Product With Same Digit            
	 206 Find Max Sub-Array                  | 218 Remove Dups From Sorted Array      
	 207 Find Next Higher Number             | 219 Reverse Integer                    
	 208 Find Single Number Space: O(1)      | 220 Reverse Words in String            
	 209 Find Single Number in Array         | 221 Sort Int with N Digits             
	 210 Find Two Sum in Array               | 222 Sort Strings with n Chars          
	 211 Longest Substr no-Repeated Chars    | 223 count non-continuous '1' bin-str   
	=============================================================================
	select the demo index (press 0 to exit):

### Some demos as examples

#### Compare Sort Algorithms

	[ SortingComparasionDemo ]
	
	Warming JVM up....3...2...1...Done
	
	######################################################################
	compare different sort algorithms:
	######################################################################
	
	
	Sorting   30000 elements
	=================================================================
	Sort                | Complexity(BigO)     | time elasped - ms.
	=================================================================
	InsertionSort       | O(n^2)               |   190.3 ms.
	-----------------------------------------------------------------
	SelectionSort       | O(n^2)               |   732.6 ms.
	-----------------------------------------------------------------
	BubbleSort          | O(n^2)               |  2471.7 ms.
	-----------------------------------------------------------------
	MergeSort           | O(nlog(n))           |     6.4 ms.
	-----------------------------------------------------------------
	OptimizedMergeSort  | O(?)                 |     4.5 ms.
	-----------------------------------------------------------------
	HeapSort            | O(nlog(n))           |     4.7 ms.
	-----------------------------------------------------------------
	QuickSort           | O(n^2)-O(nlog(n))    |     4.4 ms.
	-----------------------------------------------------------------
	RandomizedQuickSort | O(n^2)-O(nlog(n))    |     4.0 ms.
	-----------------------------------------------------------------
	
#### Merge Sort Demo

	######################################################################
	Merge Sort Demo
	######################################################################


	Sorting array:[221, 35, 8, 225, 59, 229, 94, 11, 138, 118, 43, 208, 161, 116]
	======================================================================
	[221, 35, 8, 225, 59, 229, 94, 11, 138, 118, 43, 208, 161, 116]
	Merging : [221] <-> [35]
				[59, 229]

	Merging : [59, 229] <-> [94]
					  \     / 
				 [59, 94, 229]

	Merging : [8, 35, 221, 225] <-> [59, 94, 229]
							  \     / 
					 [8, 35, 59, 94, 221, 225, 229]

	Merging : [11] <-> [138]
				 \     / 
				[11, 138]

	Merging : [118] <-> [43]
				  \     / 
				[43, 118]

	Merging : [11, 138] <-> [43, 118]
					  \     / 
				  [11, 43, 118, 138]

	Merging : [208] <-> [161]
				  \     / 
				[161, 208]

	Merging : [161, 208] <-> [116]
					   \     / 
				 [116, 161, 208]

	Merging : [11, 43, 118, 138] <-> [116, 161, 208]
							   \     / 
					  [11, 43, 116, 118, 138, 161, 208]

	Merging : [8, 35, 59, 94, 221, 225, 229] <-> [11, 43, 116, 118, 138, 161, 208]
										   \     / 
							 [8, 11, 35, 43, 59, 94, 116, 118, 138, 161, 208, 221, 225, 229]

	======================================================================
	Time elapsed:1.8

#### Heap Sort Demo
	[ HeapSortDemo ]
	
	Warming JVM up....3...2...1...Done
	
	######################################################################
	Heap Sort Demo
	######################################################################
	
	
	Sorting array:[221, 35, 8, 225, 59, 229, 94, 11, 138, 118, 43, 208, 161, 116]
	======================================================================
	[221, 35, 8, 225, 59, 229, 94, 11, 138, 118, 43, 208, 161, 116]
	Init Heap:
	
	                221                             
	         /````      ````\                
	        35              8               
	     /      \        /      \        
	    225     59      229     94      
	   /  \    /  \    /  \    /  \    
	  11  138 118 43  208 161 116 
	
	Max Heap:
	
	                229                             
	         /````      ````\                
	        225             221             
	     /      \        /      \        
	    138     118     208     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  8   161 94  
	
	
	                94                              
	         /````      ````\                
	        225             221             
	     /      \        /      \        
	    138     118     208     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  8   161 229*
	
	array status:[229]
	after max-heapifing:
	
	                225                             
	         /````      ````\                
	        138             221             
	     /      \        /      \        
	    94      118     208     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  8   161 
	
	
	                161                             
	         /````      ````\                
	        138             221             
	     /      \        /      \        
	    94      118     208     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  8   225*
	
	array status:[225, 229]
	after max-heapifing:
	
	                221                             
	         /````      ````\                
	        138             208             
	     /      \        /      \        
	    94      118     161     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  8   
	
	
	                8                               
	         /````      ````\                
	        138             208             
	     /      \        /      \        
	    94      118     161     116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  221*
	
	array status:[221, 225, 229]
	after max-heapifing:
	
	                208                             
	         /````      ````\                
	        138             161             
	     /      \        /      \        
	    94      118     8       116     
	   /  \    /  \    /  \    /  \    
	  11  35  59  43  
	     /      \        /      \        
	    94      118     8       43      
	   /  \    /  \    /  \    /  \    
	  11  35  59  
	
	
	                59                              
	         /````      ````\                
	        138             116             
	     /      \        /      \        
	    94      118     8       43      
	   /  \    /  \    /  \    /  \    
	  11  35  161*
	
	array status:[161, 208, 221, 225, 229]
	after max-heapifing:
	
	                138                             
	         /````      ````\                
	        118             116             
	     /      \        /      \        
	    94      59      8       43      
	   /  \    /  \    /  \    /  \    
	  11  35  
	
	
	                35                              
	         /````      ````\                
	        118             116             
	     /      \        /      \        
	    94      59      8       43      
	   /  \    /  \    /  \    /  \    
	  11  138*
	
	array status:[138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	        118             
	     /      \        
	    94      116     
	   /  \    /  \    
	  35  59  8   43  
	
	
	        11              
	     /      \        
	    94      116     
	   /  \    /  \    
	  35  59  8   43  
	
	array status:[118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	        116             
	     /      \        
	    94      43      
	   /  \    /  \    
	  35  59  8   11  
	
	
	        11              
	     /      \        
	    94      43      
	   /  \    /  \    
	  35  59  8   116*
	
	array status:[116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	        94              
	     /      \        
	    59      43      
	   /  \    /  \    
	  35  11  8   
	
	
	        8               
	     /      \        
	    59      43      
	   /  \    /  \    
	  35  11  94* 
	
	array status:[94, 116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	        59              
	     /      \        
	    35      43      
	   /  \    /  \    
	  8   11  
	
	
	        11              
	     /      \        
	    35      43      
	   /  \    /  \    
	  8   59* 
	
	array status:[59, 94, 116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	    43      
	   /  \    
	  35  11  
	
	
	    8       
	   /  \    
	  35  11  
	
	array status:[43, 59, 94, 116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	    35      
	   /  \    
	  8   11  
	
	
	    11      
	   /  \    
	  8   35* 
	
	array status:[35, 43, 59, 94, 116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	
	
	  8
	  |
	  11*
	
	array status:[11, 35, 43, 59, 94, 116, 118, 138, 161, 208, 221, 225, 229]
	after max-heapifing:
	
	
	======================================================================
	Time elapsed:36.2


## Requirement & Install
todo

## Start

##screencast/screenshot?

