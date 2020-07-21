package mihajlovic.jelena.flames_game;

public class FlamesGame {

    private String firstPersonName;
    private String secondPersonName;

    public FlamesGame(String firstPersonName, String secondPersonName) {
	this.firstPersonName = firstPersonName;
	this.secondPersonName = secondPersonName;
    }

    public String getFirstPersonName() {
	return firstPersonName;
    }

    public void setFirstPersonName(String firstPersonName) {
	this.firstPersonName = firstPersonName;
    }

    public String getSecondPersonName() {
	return secondPersonName;
    }

    public void setSecondPersonName(String secondPersonName) {
	this.secondPersonName = secondPersonName;
    }

    private String removeCommonLetters() {
	String person1 = firstPersonName;
	String person2 = secondPersonName;
	String person = firstPersonName.length() > secondPersonName.length() ? secondPersonName : firstPersonName;
	for (int i = 0; i < person.length(); i++) {
	    String litteral = "" + person.charAt(i);
	    if (person1.contains(litteral) && person2.contains(litteral)) {
		person1 = person1.replaceFirst(litteral, "");
		person2 = person2.replaceFirst(litteral, "");
	    }
	}
	return person1 + person2;
    }

    private String getFlame() {
	int count = removeCommonLetters().length();
	String flame = Flames.getAcronym();
	int index = 0;
	while (flame.length() > 1) {
	    if (flame.length() == index + count) {
		flame = flame.replace(flame.charAt(index + count - 1) + "", "");
		index = 0;
	    } else {
		index = flame.length() > index + count ? index + count - 1 : (index + count - 1) % flame.length();
		flame = flame.replace(flame.charAt(index) + "", "");
	    }
	}
	return flame;
    }

    public void play() {
	String result = Flames.valueOf(getFlame()).toString();
	System.out.println("Result for " + firstPersonName + " and " + secondPersonName + " is: " + result);
    }

}
