package havlak;

public class LSG extends dart._runtime.base.DartObject implements havlak.LSG_interface
{
    public static dart._runtime.types.simple.InterfaceTypeInfo dart2java$typeInfo = new dart._runtime.types.simple.InterfaceTypeInfo("havlak.LSG");
    static {
      havlak.LSG.dart2java$typeInfo.superclass = new dart._runtime.types.simple.InterfaceTypeExpr(dart._runtime.helpers.ObjectHelper.dart2java$typeInfo);
    }
    public int loopCounter;
    public dart._runtime.base.DartList<havlak.SimpleLoop_interface> loops;
    public havlak.SimpleLoop_interface root;
  
    public LSG(dart._runtime.types.simple.Type type)
    {
      super((dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker) null, type);
      this._constructor();
    }
    public LSG(dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker arg, dart._runtime.types.simple.Type type)
    {
      super(arg, type);
    }
  
    protected void _constructor()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      this.loopCounter = 1;
      this.loops = (dart._runtime.base.DartList) dart._runtime.base.DartList.Generic._fromArguments(havlak.SimpleLoop_interface.class);
      this.root = new havlak.SimpleLoop(dart2java$localTypeEnv.evaluate(new dart._runtime.types.simple.InterfaceTypeExpr(havlak.SimpleLoop.dart2java$typeInfo)), 0);
      super._constructor();
      this.getRoot().setNestingLevel_(0);
      this.getLoops().add(this.getRoot());
    }
    public havlak.SimpleLoop_interface createNewLoop()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      havlak.LSG_interface __tempVar_0;
      int __tempVar_1;
      int __tempVar_2;
      havlak.SimpleLoop_interface loop = new havlak.SimpleLoop(dart2java$localTypeEnv.evaluate(new dart._runtime.types.simple.InterfaceTypeExpr(havlak.SimpleLoop.dart2java$typeInfo)), dart._runtime.helpers.LetExpressionHelper.comma(__tempVar_0 = this, dart._runtime.helpers.LetExpressionHelper.comma(__tempVar_1 = __tempVar_0.getLoopCounter(), dart._runtime.helpers.LetExpressionHelper.comma(__tempVar_2 = __tempVar_0.setLoopCounter((__tempVar_1 + 1)), __tempVar_1))));
      return loop;
    }
    public void addLoop(havlak.SimpleLoop_interface loop)
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      this.getLoops().add(loop);
      return;
    }
    public int checksum()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      int result = this.getLoops().getLength();
      java.lang.Object ebefore = null;
      for (havlak.SimpleLoop_interface e : this.getLoops())
      {
        result = havlak.__TopLevel.mix(result, e.checksum());
      }
      return havlak.__TopLevel.mix(result, this.getRoot().checksum());
    }
    public int getNumLoops()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      return this.getLoops().getLength();
    }
    public int getLoopCounter()
    {
      return this.loopCounter;
    }
    public dart._runtime.base.DartList<havlak.SimpleLoop_interface> getLoops()
    {
      return this.loops;
    }
    public havlak.SimpleLoop_interface getRoot()
    {
      return this.root;
    }
    public int setLoopCounter(int value)
    {
      this.loopCounter = value;
      return value;
    }
}