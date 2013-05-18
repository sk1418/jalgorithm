README file of project jalgorithm

##Introduction

Some classic algorithm implemented in Java with demos. (only CLI available)

##Requirement & Install
todo

##Start
todo


	java -c xxx.jar
	
###Implemented algorithms and demos so far:

	Available Demos:
	=================================================

	-- Sortings --

	   1 ....... SortingComparasion            
	   2 ....... InsertionSort                 
	   3 ....... BubbleSort                    
	   4 ....... MergeSort                     
	   5 ....... MergeSort_Optimized           
	   6 ....... HeapSort                      
	   7 ....... QuickSort                     
	   8 ....... RandomizedQuickSort           

	-- Sorting in linear time --

	  11 ....... CountingSort                  
	  12 ....... BucketSort                    
	  13 ....... RadixSort                     

	-- Problems --

	 100 ....... Problem_MaxSubArray           
	 101 ....... Problem_CountInversionPairs   
	 102 ....... Problem_FindHeavyIntegers     
	 103 ....... Problem_SortingIntegerWithNDigits
	 104 ....... Problem_SortingStringsWithNChars
	 105 ....... Problem_FindNextHigherNumber  
	 106 ....... Problem_TwoSumInArray         
	 107 ....... Problem_PlusOne               
	 108 ....... Problem_ReverseInteger        
	 109 ....... Problem_MedianOfTwoSortedArrays
	 110 ....... Problem_AddTwoNumbers         
	 111 ....... Problem_FindAllSubSets        
	 112 ....... Problem_RotateList            
	=================================================
	select the demo index (press 0 to exit):	

###Some demoes as examples

####SortingComparasion

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
	

####Heap Sort
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


##Requirement & Install
todo

##Start

##screencast/screenshot?

