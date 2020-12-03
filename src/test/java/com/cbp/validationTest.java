
  package com.cbp;
  
  //import org.junit.jupiter.api.Test;
  
  import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cbp.sanctions.util.Validation;
  
  public class validationTest {
  
  @Test public void test1() { Validation test=new Validation(); boolean
  output=test.isValidAccNo("187462"); assertEquals(false,output);
  
  
  }
  
  @Test public void test2() { Validation test=new Validation(); boolean
  output=test.isValidAccNo("187462567234"); assertEquals(true,output);
  
  
  }
  
  @Test public void test3() { Validation test=new Validation(); boolean
  output=test.isValidAccNo("18746-6822131`343`22"); assertEquals(false,output);
  
  
  }
  
  @Test public void test4() { Validation test=new Validation(); boolean
  output=test.isValidAccNo("76341000347148"); assertEquals(true,output);
  
  
  }
  
  @Test public void test5() { Validation test=new Validation(); boolean
  output=test.isValidAccNo("340157289345"); assertEquals(true,output);
  
  
  }
  
  @Test public void test6() { Validation test=new Validation(); boolean
  output=test.isValidAmt("67654.23"); assertEquals(true,output);
  
  }
  
  @Test public void test7() { Validation test=new Validation(); boolean
  output=test.isValidAmt("-67654.23"); assertEquals(false,output);
  
  }
  
  @Test public void test8() { Validation test=new Validation(); boolean
  output=test.isValidAmt("676546854333557678.23"); assertEquals(false,output);
  
  }
  
  @Test public void test9() { Validation test=new Validation(); boolean
  output=test.isValidAmt("57678908.3"); assertEquals(true,output);
  
  }
  
  @Test public void test10() { Validation test=new Validation(); boolean
  output=test.isValidAmt("57678.398"); assertEquals(false,output);
  
  }
  
  
  @Test public void test11() { Validation test=new Validation(); boolean
  output=test.isValidName("lokesh123"); assertEquals(true,output); }
  
  @Test public void test12() { Validation test=new Validation(); boolean
  output=test.isValidName("Lokesh12-"); assertEquals(false,output); }
  
  @Test public void test13() { Validation test=new Validation(); boolean
  output=test.isValidName("12456"); assertEquals(true,output); }
  
  @Test public void test14() { Validation test=new Validation(); boolean
  output=test.isValidName("abcd"); assertEquals(true,output); }
  
  @Test public void test15() { Validation test=new Validation(); boolean
  output=test.isValidName("agtdb@3#$%"); assertEquals(false,output); }
  
  @Test public void test16() { Validation test=new Validation(); boolean
  output=test.isValidName("lokesh123"); assertEquals(true,output); }
  
  @Test public void test17() { Validation test=new Validation(); boolean
  output=test.isValidName("Lokesh12-"); assertEquals(false,output); }
  
  @Test public void test18() { Validation test=new Validation(); boolean
  output=test.isValidName("12456"); assertEquals(true,output); }
  
  @Test public void test19() { Validation test=new Validation(); boolean
  output=test.isValidName("abcd"); assertEquals(true,output); }
  
  @Test public void test20() { Validation test=new Validation(); boolean
  output=test.isValidName("agtdb@3#$%"); assertEquals(false,output); }
  
  
  @Test public void test21() { Validation test=new Validation(); boolean
  output=test.isValidRef("1634581hdah6433"); assertEquals(true,output); }
  
  @Test
  
  public void test22() { Validation test=new Validation(); boolean
  output=test.isValidRef("3748fa./,;;[p'"); assertEquals(false,output); }
  
  @Test
  
  public void test23() { Validation test=new Validation(); boolean
  output=test.isValidRef("afbhgaf1435jhf"); assertEquals(true,output); }
  
  @Test public void test24() { Validation test=new Validation(); boolean
  output=test.isValidRef("47632vbavdva"); assertEquals(true,output); }
  
  @Test public void test25() { Validation test=new Validation(); boolean
  output=test.isValidRef("......@@@##$$%%^"); assertEquals(false,output); }
  
  
  
  }
 