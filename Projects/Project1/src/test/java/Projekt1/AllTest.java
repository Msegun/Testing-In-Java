package Projekt1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Cyfrokrad.class, CyfrokradParametrized.class,
				HultajHochla.class, Nieksztaltek.class,
				Heheszki.class, HeheszkiParametrized.class, TiTit.class })
public class AllTest {

}
