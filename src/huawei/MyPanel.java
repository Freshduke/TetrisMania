package huawei;

public class MyPanel {
	public Element[][] table = new Element[12][8];
	
	public MyPanel() {
		for(int i=0;i<12;i++) {
			for (int j=0;j<8;j++) {
				this.table[i][j] = Element.point;
				}
		}
	}
}