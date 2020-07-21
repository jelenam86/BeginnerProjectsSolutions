package mihajlovic.jelena.flames_game;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

public enum Flames {

    F("Friends"), L("Lovers"), A("Affection"), M("Marriage"), E("Enemies"), S("Siblings");

    private String name;

    private Flames(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return name;
    }

    public static String getAcronym() {
	// when need to use effectively final variable in lambda
	AtomicReference<String> acronym = new AtomicReference<String>("");
	// all enum constants in natural order
	EnumSet.allOf(Flames.class).forEach(flame -> acronym.set(acronym.get() + flame.name()));
	return acronym.get();
    }

}
