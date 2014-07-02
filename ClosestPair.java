import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


class Point2D implements Comparable<Point2D>{
	private	double x;
	private double y;
	
    public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) x = 0.0;  // convert -0.0 to +0.0
        if (y == 0.0) y = 0.0;  // convert -0.0 to +0.0
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
    	return this.x;
    }
    
    public double getY(){
    	return this.y;
    }
    
    public void setLocation(double x, double y){
    	this.x = x;
    	this.y = y;
    }
   
    // compare points according to their x-coordinate
    public static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }

    // compare points according to their y-coordinate
    public static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.y < q.y) return -1;
            if (p.y > q.y) return +1;
            return 0;
        }
    }
    
    public void displayPoint(){
    	System.out.println(x+","+ y);
    }
    
    public int compareTo(Point2D that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }
    
    public double distanceTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
    }
 	
}

public class ClosestPair{
	
	private Point2D best1, best2;
	private double bestdistance = Double.POSITIVE_INFINITY;
	
	public ClosestPair(Point2D[] points, int N){
		if(N<=1)
			return;
		
		//sort point by x-coordinate
		Point2D[] px = new Point2D[N];
		System.arraycopy(points, 0, px, 0, N);
		Arrays.sort(px, new Point2D.XOrder());
		
		//Check for co-incident points
		for(int i=0; i<N-1;i++){
			if(px[i].equals(px[i+1])){
				bestdistance = 0.0;
				best1 = px[i];
				best2 = px[i+1];
			}
		}
		
		//sort point by y-coordinate
		Point2D[] py = new Point2D[N];
		System.arraycopy(points, 0, py, 0, N);
		Arrays.sort(py, new Point2D.YOrder());
		
		Point2D[] aux = new Point2D[N];
		
		closest(px, py, aux, 0, N-1);
		
	}
	
	private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int lo, int hi) {
		if (hi <= lo) 
	    	return Double.POSITIVE_INFINITY;
	
	    int mid = lo + (hi - lo) / 2;
	    Point2D median = pointsByX[mid];
	
	    // compute closest pair with both endpoints in left subarray or both in right subarray
	    double delta1 = closest(pointsByX, pointsByY, aux, lo, mid);
	    double delta2 = closest(pointsByX, pointsByY, aux, mid+1, hi);
	    double delta = Math.min(delta1, delta2);
	
	    System.out.println("delta1: "+delta1+" delta2: "+delta2+" delta: "+delta);
	    // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
	    merge(pointsByY, aux, lo, mid, hi);
	
	    // aux[0..M-1] = sequence of points closer than delta, sorted by y-coordinate
	    int M = 0;
	    for (int i = lo; i <= hi; i++) {
	        if (Math.abs(pointsByY[i].getX() - median.getX()) < delta)
	            aux[M++] = pointsByY[i];
	    }
	
	    // compare each point to its neighbors with y-coordinate closer than delta
	    for (int i = 0; i < M; i++) {
	        // a geometric packing argument shows that this loop iterates at most 7 times
	        for (int j = i+1; (j < M) && (aux[j].getY() - aux[i].getY() < delta); j++) {
	            double distance = aux[i].distanceTo(aux[j]);
	            if (distance < delta) {
	                delta = distance;
	                if (distance < bestdistance) {
	                    bestdistance = delta;
	                    best1 = aux[i];
	                    best2 = aux[j];
	                }
	            }
	        }
	    }
	    return delta;
    }

    public void getEither() { 
    	System.out.println(best1.getX()+","+best1.getY()); 
    }
    
    public void getOther()  {
    	System.out.println(best2.getX()+","+best2.getY()); 
    }

    public double getDistance() {
        return bestdistance;
    }
    
    private static boolean less(Point2D v, Point2D w) {
        return (v.compareTo(w) < 0);
    }
    
    private static void merge(Point2D[] a, Point2D[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
    
        // merge back to a[] 
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid)              
            	a[k] = aux[j++];
            else if(j > hi)               
            	a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
            	a[k] = aux[j++];
            else
            	a[k] = aux[i++];
        }
    }
    
	public static void main(String[] args) throws Exception{
		String input = "";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		double x;
		double y;
		input = bf.readLine();
		int N = Integer.parseInt(input);
		Point2D[] points2D = new Point2D[N];
		
		for(int i=0; i<N; i++){
			input = bf.readLine();
			x = Double.parseDouble(input);
			input = bf.readLine();
			y = Double.parseDouble(input);
			points2D[i]= new Point2D(x,y);
		}

		/*Arrays.sort(points2D,new Point2D.XOrder());
		System.out.println("Sorted by X order:");
		for(int i=0;i<N; i++){
			points2D[i].displayPoint();
		}*/
		ClosestPair closest = new ClosestPair(points2D,N);
		System.out.println();
		System.out.print(closest.getDistance() + " from ");
		closest.getEither();
		System.out.print(" to ");
		closest.getOther();
	}
}