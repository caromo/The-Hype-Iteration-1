package sample;

public class tile {
    public Occupy occupy;
    public Holding holding;
    public char decal;
    private Boolean passable;

    public tile(tileObject objType) {
        passable = true;
        holding = new Holding(this, objType);
    }

    public tile() {}

    //Performs the action associated with the tileObject
    public int applyEffect() {

        if (occupy != null && holding != null) {
            System.out.println("APPLY2");
            int scenario = holding.getObject().getScenario();
            tileObject temp = holding.getObject();
            if(scenario == 1 || scenario == 2 || scenario == 3)  {    //Area effect
                System.out.println("APPLY");
                ((AreaEffect) temp).setDuration(20);
                ((AreaEffect) temp).setAmount(3);
                ((AreaEffect) temp).startEf();

                return -1;
            }
            else if(scenario == 4) {      //Item
                occupy.getPlayer().acquireItem((Item)temp);
                return -1;
            }
            else if (scenario == 5) {
                return ((MapTransition) temp).getDestination();
            }
        }
        return -1;
    }
    // Takes in a Decal D, and Scenario Number SN, the specification of that SN, and Equipment Data is applicable
    public void fill(char D, int SN, int spec, int EQdata) {
        decal = D;
        System.out.println("Decal: " + D + " SN: " + SN + " SPEC " + spec + " EQdata " + EQdata );
        if (SN == 1) { // Area Effect
            holding = new Holding(this, new damageEffect(SN, spec));
        } else if(SN == 2){
            holding = new Holding(this, new healingEffect(SN, spec));
        } else if(SN == 3){
            holding = new Holding(this, new expEffect(SN, spec));
        } else if (SN == 4) { // Item
            holding = new Holding(this, new Item(SN, spec));
        } else if (SN == 5) { // Map Transition
            holding = new Holding(this, new MapTransition(SN, spec));
        } else if (SN == 6) { // Equipment
            if (spec / 100 == 1) {
                holding = new Holding(this, new Armor(spec / 100, spec, EQdata));
            }
            if (spec / 100 == 2) {
                holding = new Holding(this, new Weapon(spec / 100, spec, EQdata));
            }
            if (spec / 100 == 3) {
                holding = new Holding(this, new Ring(spec / 100, spec, EQdata));
            }
        }

        switch(decal){
            case 'G':
                setPassable(true);
                break;
            case 'M':
                setPassable(false);
                break;
            case 'W':
                setPassable(false);
                break;
        }
    }

    //Provides the encrypted info of the tile as a String
    public String spill() {
        StringBuffer st = new StringBuffer();
        st.append("");

        switch(decal) {
            case 'G':
                st.append("G");
                break;
            case 'W':
                st.append("W");
                break;
            case 'M':
                st.append("M");
                break;
            default:
                st.append(Integer.toString(((Equipment)holding.getObject()).getEquipmentID()));
                if(holding.getObject().getEffect() < 10) { st.append("0" + Integer.toString(holding.getObject().getEffect())); }
                else{ st.append(Integer.toString(holding.getObject().getEffect()));	}
                break;
        }

        if(Character.isLetter(st.charAt(0))) {
            if(holding == null){
                st.append("0000");
                return st.toString();
            }

            switch(holding.getObject().getScenario()) {
                case 0:
                    st.append("0");
                    break;
                case 1:
                    st.append("1");
                    st.append(Integer.toString(holding.getObject().getEffect()) + "00");
                    break;
                case 2:
                    st.append("2");
                    st.append(Integer.toString(holding.getObject().getEffect()) + "00");
                    break;
                case 3:
                    st.append("3");
                    st.append(Integer.toString(holding.getObject().getEffect()) + "00");
                    break;
                case 4:
                    st.append("4");
                    st.append(Integer.toString(holding.getObject().getEffect()));
                    break;
                case 5:
                    st.append("5");
                    st.append(Integer.toString(holding.getObject().getEffect()));
                    break;
            }
        }

        return st.toString();
    }

    public int getScenario() {
        if(holding == null) { return -1;  }
        return holding.getObject().getScenario();
    }

    public boolean getPassable() { return passable;  }

    public void setPassable(Boolean passable) { this.passable = passable;  }

}
