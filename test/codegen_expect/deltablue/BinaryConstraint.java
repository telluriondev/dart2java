package deltablue;

public abstract class BinaryConstraint extends deltablue.Constraint
{
    public deltablue.Variable v1 = null;
    public deltablue.Variable v2 = null;
    public java.lang.Integer direction = null;
  
    public BinaryConstraint(deltablue.Variable v1, deltablue.Variable v2, deltablue.Strength strength)
    {
      super((dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker) null);
      this._constructor(v1, v2, strength);
    }
    public BinaryConstraint(dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker arg)
    {
      super(arg);
    }
  
    protected void _constructor(deltablue.Variable v1, deltablue.Variable v2, deltablue.Strength strength)
    {
      this.direction = deltablue.__TopLevel.NONE;
      this.v1 = v1;
      this.v2 = v2;
      super._constructor(strength);
      this.addConstraint();
    }
    public void chooseMethod(java.lang.Integer mark)
    {
      if (dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV1().getMark(), mark))
      {
        this.setDirection((((!dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV2().getMark(), mark)) && deltablue.Strength.stronger(this.getStrength(), this.getV2().getWalkStrength()))) ? (deltablue.__TopLevel.FORWARD) : (deltablue.__TopLevel.NONE));
      }
      if (dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV2().getMark(), mark))
      {
        this.setDirection((((!dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV1().getMark(), mark)) && deltablue.Strength.stronger(this.getStrength(), this.getV1().getWalkStrength()))) ? (deltablue.__TopLevel.BACKWARD) : (deltablue.__TopLevel.NONE));
      }
      if (deltablue.Strength.weaker(this.getV1().getWalkStrength(), this.getV2().getWalkStrength()))
      {
        this.setDirection((deltablue.Strength.stronger(this.getStrength(), this.getV1().getWalkStrength())) ? (deltablue.__TopLevel.BACKWARD) : (deltablue.__TopLevel.NONE));
      }
      else
      {
        this.setDirection((deltablue.Strength.stronger(this.getStrength(), this.getV2().getWalkStrength())) ? (deltablue.__TopLevel.FORWARD) : (deltablue.__TopLevel.BACKWARD));
      }
    }
    public void addToGraph()
    {
      this.getV1().addConstraint(this);
      this.getV2().addConstraint(this);
      this.setDirection(deltablue.__TopLevel.NONE);
    }
    public java.lang.Boolean isSatisfied()
    {
      return (!dart._runtime.helpers.ObjectHelper.operatorEqual(this.getDirection(), deltablue.__TopLevel.NONE));
    }
    public void markInputs(java.lang.Integer mark)
    {
      this.input().setMark(mark);
    }
    public deltablue.Variable input()
    {
      return (dart._runtime.helpers.ObjectHelper.operatorEqual(this.getDirection(), deltablue.__TopLevel.FORWARD)) ? (this.getV1()) : (this.getV2());
    }
    public deltablue.Variable output()
    {
      return (dart._runtime.helpers.ObjectHelper.operatorEqual(this.getDirection(), deltablue.__TopLevel.FORWARD)) ? (this.getV2()) : (this.getV1());
    }
    public void recalculate()
    {
      deltablue.Variable ihn = this.input();
      deltablue.Variable out = this.output();
      out.setWalkStrength(deltablue.Strength.weakest(this.getStrength(), ihn.getWalkStrength()));
      out.setStay(ihn.getStay());
      if (out.getStay())
      {
        this.execute();
      }
    }
    public void markUnsatisfied()
    {
      this.setDirection(deltablue.__TopLevel.NONE);
    }
    public java.lang.Boolean inputsKnown(java.lang.Integer mark)
    {
      deltablue.Variable i = this.input();
      return ((dart._runtime.helpers.ObjectHelper.operatorEqual(i.getMark(), mark) || i.getStay()) || dart._runtime.helpers.ObjectHelper.operatorEqual(i.getDeterminedBy(), null));
    }
    public void removeFromGraph()
    {
      if ((!dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV1(), null)))
      {
        this.getV1().removeConstraint(this);
      }
      if ((!dart._runtime.helpers.ObjectHelper.operatorEqual(this.getV2(), null)))
      {
        this.getV2().removeConstraint(this);
      }
      this.setDirection(deltablue.__TopLevel.NONE);
    }
    public deltablue.Variable getV1()
    {
      return this.v1;
    }
    public deltablue.Variable getV2()
    {
      return this.v2;
    }
    public java.lang.Integer getDirection()
    {
      return this.direction;
    }
    public deltablue.Variable setV1(deltablue.Variable value)
    {
      this.v1 = value;
      return value;
    }
    public deltablue.Variable setV2(deltablue.Variable value)
    {
      this.v2 = value;
      return value;
    }
    public java.lang.Integer setDirection(java.lang.Integer value)
    {
      this.direction = value;
      return value;
    }
}
