public class boxType {

    private double length;
    private double width;
    private double height;

    public boxType(double l, double w, double h) { // Constructor
        length = l;
        width = w;
        height = h;
    }

    public double getVolume() { // sets value of length from main program//

        return length * width * height;
    }

    public boolean fitsInBoxType(Basketball b) {
        double diameter = b.getRadius() * 2;
        if (diameter < length && diameter < width && diameter < height)
            return true;
        else
            return false;
    }

    public double emptySpace(Basketball b){
		double empty =0;
		if (fitsInBoxType(b)){
			empty = this.getVolume() - b.getVolume();
			       return empty;
		}
		else
			empty = this.getVolume();
		    return empty;	
    }
    
    	// Getters and Setters//
	public void setLength(double length){
		this.length = length;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public double getLength (){
		return length;
	}
	public double getHeight (){
		return height;
	}
	public double getWidth (){
		return width;
	}

}