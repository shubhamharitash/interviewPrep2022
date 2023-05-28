Here, instead of LinkedList, set is used

Implementation graph used 
`HashMap<Integer, TreeSet<Integer> > graph`
It optimized edge detection step since now we can find an edge in log(Degree) time.