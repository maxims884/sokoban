public class Model {
    private Viewer viewer;
    private int[][] desktop;

    private int indexX;
    private int indexY;          
    private int[][] arrayIndexies;

    Model(Viewer viewer) {
	this.viewer = viewer;
	desktop = new int[][]{
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 1, 3, 4, 0, 0, 0, 2},
			{2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
			};

	indexX = 4;
	indexY = 3;


	initialization();


	
    }

    public void initialization() {
	int counterFour = 0;
	for(int i = 0; i < desktop.length;i++) {
	    for(int j = 0; j < desktop[i].length;j++) {

		if(desktop[i][j] == 4) {
			counterFour = counterFour + 1;
		}

	    }
	}

	arrayIndexies = new int[2][counterFour];

	int count = 0;
	for(int i = 0; i < desktop.length;i++) {
	    for(int j = 0; j < desktop[i].length;j++) {
		if(desktop[i][j] == 4) {
                        arrayIndexies[0][count] = i;
                        arrayIndexies[1][count] = j;			
			count++;
		}
	    }
	}

	for(int i = 0; i < arrayIndexies.length;i++) {
	    for(int j = 0; j < arrayIndexies[i].length;j++) {
		System.out.print(arrayIndexies[i][j] + " ");
	    }
	System.out.println();
	}
	System.out.println();
	System.out.println();


    }
    public int[][] getDesktop() {
	return desktop;
    }

    public void move(String direction) {
	System.out.println(direction);

	switch(direction) {
		case "Left":
			moveLeft();
		break;
		case "Up":
			moveUp();
		break;

		case "Right":
			moveRigth();
		break;

		case "Down":
			moveDown();
		break;

		default:
			return;

	}
	print();
	check();
	viewer.update();
    }


    private void moveLeft() {

	if(desktop[indexX][indexY - 1] == 3) {
		if(desktop[indexX][indexY - 2] == 0  || desktop[indexX][indexY - 2] == 4) {
			desktop[indexX][indexY - 1] = 0;
			desktop[indexX][indexY - 2] = 3;
		}
	}


	if(desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
		desktop[indexX][indexY] = 0;
		indexY = indexY - 1;
		desktop[indexX][indexY] = 1;
	}
    }


    private void moveUp() {

	if(desktop[indexX - 1][indexY] == 3) {
		if(desktop[indexX - 2][indexY] == 0  || desktop[indexX][indexY - 2] == 4) {
			desktop[indexX - 1][indexY] = 0;
			desktop[indexX - 2][indexY] = 3;
		}
	}


	if(desktop[indexX - 1][indexY] == 0  || desktop[indexX - 1][indexY] == 4) {
		desktop[indexX][indexY] = 0;
		indexX = indexX - 1;
		desktop[indexX][indexY] = 1;
	}
    }

    private void moveRigth() {

	if(desktop[indexX][indexY + 1] == 3) {
		if(desktop[indexX][indexY + 2] == 0  || desktop[indexX][indexY + 2] == 4) {
			desktop[indexX][indexY + 1] = 0;
			desktop[indexX][indexY + 2] = 3;
		}
	}

	if(desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
		desktop[indexX][indexY] = 0;
		indexY = indexY + 1;
		desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {

	if(desktop[indexX + 1][indexY] == 3) {
		if(desktop[indexX + 2][indexY] == 0  || desktop[indexX][indexY + 2] == 4) {
			desktop[indexX + 1][indexY] = 0;
			desktop[indexX + 2][indexY] = 3;
		}
	}


	if(desktop[indexX + 1][indexY] == 0  || desktop[indexX + 1][indexY] == 4) {
		desktop[indexX][indexY] = 0;
		indexX = indexX + 1;
		desktop[indexX][indexY] = 1;
	}
    }


    private void check() {
	    int t = 0;
	    for(int j = 0; j < arrayIndexies[0].length;j++) {
		int x = arrayIndexies[0][t];
		int y = arrayIndexies[1][t];
		if(desktop[x][y] == 0) {
			desktop[x][y] = 4;
			break;
		}
		t++;
	    }

	javax.swing.JOptionPane.showMessageDialog(viewer.getMyFrame(), "You won!");
    }

    private void print() {

	for(int i = 0; i < desktop.length;i++) {
	    for(int j = 0; j < desktop[i].length;j++) {
		System.out.print(desktop[i][j] + " ");
	    }
	System.out.println();
	}
	System.out.println();
	System.out.println();

    }

}