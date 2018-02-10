package sample;


public class tile {
    public Occupy occupy;
    public Holding holding;
    public char decal;
    private Boolean passable;

    public tile(tileObject objType) {
        passable = true;
        holding = new Holding(this, objType);
        if(holding.getObject().getScenario() == 0) {
            if(((Terrain)holding.getObject()).getTerrainType() == 0) {
                setPassable(true);
            } else {
                setPassable(false);
            }
        }
    }

    public tile() {}

    //Performs the action associated with the tileObject
    public void applyEffect() {
        if (occupy != null && holding != null) {
            int scenario = holding.getObject().getScenario();
            tileObject temp = holding.getObject();
            if(scenario == 1)  {    //Area effect

            } else if(scenario == 4) {      //Item
                occupy.getPlayer().acquireItem((Item)temp);
            }
        }
    }
    // Takes in a Decal D, and Scenario Number SN, the specification of that SN, and Equipment Data is applicable
    public void fill(char D, int SN, int spec, int EQdata) {
        decal = D;
        if (SN == 1 || SN == 2 || SN == 3) { // Area Effect
            holding = new Holding(this, new AreaEffect(SN, spec));
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
    }

    //Provides the encrypted info of the tile as a String
    public String spill() {
    	StringBuffer st = null;
    	st.append("");

    	switch(decal) {
    	case 'G':
    		st.append("G");
    	case 'W':
    		st.append("W");
    	case 'M':
    		st.append("M");
    	default:
    		st.append(Integer.toString(((Equipment)holding.getObject()).getEquipmentID()));
    		if(holding.getObject().getEffect() < 10) { st.append("0" + Integer.toString(holding.getObject().getEffect())); }
    		else{ st.append(Integer.toString(holding.getObject().getEffect()));	}
    		break;
    	}

    	if(Character.isLetter(st.charAt(0))) {
    		switch(holding.getObject().getScenario()) {
    		case 0:
    			st.append("0");
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
