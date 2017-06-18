package application;

import java.util.ArrayList;
import java.util.ListIterator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Taschenrechner {
	// #Textfeld
	@FXML
	public TextField textField;

	// #Zahlen1-9
	@FXML
	public Button button0;
	@FXML
	public Button button1;
	@FXML
	public Button button2;
	@FXML
	public Button button3;
	@FXML
	public Button button4;
	@FXML
	public Button button5;
	@FXML
	public Button button6;
	@FXML
	public Button button7;
	@FXML
	public Button button8;
	@FXML
	public Button button9;
	// #Matheoperatoren
	@FXML
	public Button buttonminus;
	@FXML
	public Button buttonplus;
	@FXML
	public Button buttonmult;
	@FXML
	public Button buttondiv;
	@FXML
	public Button buttonequal;
	@FXML
	public Button buttoncomma;
	@FXML
	public String result;
	@FXML
	ArrayList<String> alist = new ArrayList<String>();
	
	public void handleTextField(){
		textField.setEditable(false);
	}
	

	public void handleButton0() {
		alist.add("0");
		this.output();
	}

	public void handleButton1() {
		alist.add("1");
		this.output();
	}

	public void handleButton2() {
		alist.add("2");
		this.output();
	}

	public void handleButton3() {
		alist.add("3");
		this.output();
	}

	public void handleButton4() {
		alist.add("4");
		this.output();
	}

	public void handleButton5() {
		alist.add("5");
		this.output();
	}

	public void handleButton6() {
		alist.add("6");
		this.output();
	}

	public void handleButton7() {
		alist.add("7");
		this.output();
	}

	public void handleButton8() {
		alist.add("8");
		this.output();
	}

	public void handleButton9() {
		alist.add("9");
		this.output();
	}

	public void handleButtoncomma() {
		alist.add(".");
		this.output();
	}

	public void handleButtonmult() {
		alist.add("*");
		this.output();
	}

	public void handleButtondiv() {
		alist.add("/");
		this.output();
	}

	public void handleButtonminus() {
		alist.add("-");
		this.output();
	}

	public void handleButtonplus() {
		alist.add("+");
		this.output();
	}

	public void handleButtonequal() {
		this.calculate();
		this.output();
	}

	public void output() {
		String input = "";
		for (ListIterator<String> iterator = alist.listIterator(); iterator.hasNext();) {
				input = input.concat(iterator.next());
		}
		textField.setText(input);
	}


	public void calculate() {
		// #Save#Computing#Output
		//ArrayList<Double> res = new ArrayList<Double>();
		
		/**WICHTIG!: Die Reihenfolge vom Code gibt die Priorit‰t der Berechnung an. 
		 * Zuerst kommt mal/geteilt und dann +/-
		 * Auﬂerdem durchlaufe ich jede Operation seperat um die Reihenfolge der Berechnung sicherzustellen:
		 * Nachdem er alle Mal Operatoren berechnet hat, berechnet er erst die geteitl Operatoren usw. 
		 * "Was zuerst kommt malt zuerst"**/
		// 1.Multipliy
		for (int i = 0; i < alist.size(); i++) {
			/**Wenn ein ein * gefunden wird, 
			 * dann hol dir die Zahlen vor und nach dem Operator 
			 * und f¸hre multipliziere sie miteinander
			 * und dann lˆsche die zwei Zahlen und den Operator aus der Liste
			 * und dann f¸ge das Ergebnis einer neuen ArrayListe hinzu, dass
			 * die Ergebnisse entgegennimmt**/
			if (alist.get(i).equals("*")) {
				Double op1 = Double.parseDouble(alist.get(i - 1));
				Double op2 = Double.parseDouble(alist.get(i + 1));
				Double result = op1 * op2;
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.add(i - 1, String.valueOf(result));
//				res.add(result);
				i=0;
			}
			
		}
	
		// 2.Divide
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).equals("/")) {
				Double op1 = Double.parseDouble(alist.get(i - 1));
				Double op2 = Double.parseDouble(alist.get(i + 1));
				Double result = op1 / op2;
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.add(i - 1, String.valueOf(result));
//				res.add(result);
				i=0;
			}
		}

		// 3.Add
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).equals("+")) {
				Double op1 = Double.parseDouble(alist.get(i - 1));
				Double op2 = Double.parseDouble(alist.get(i + 1));
				Double result = op1 + op2;
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.add(i - 1, String.valueOf(result));
//				res.add(result);
				i=0;
			}
		}

		// 4.Substract
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).equals("-")) {
				Double op1 = Double.parseDouble(alist.get(i - 1));
				Double op2 = Double.parseDouble(alist.get(i + 1));
				Double result = op1 - op2;
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.remove(i - 1);
				alist.add(i - 1, String.valueOf(result));
//				res.add(result);
				i=0;
			}
		}

//		return res;
	}

	public Taschenrechner() {

	}

}
