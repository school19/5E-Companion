package com.schoolerc.dungeoncompanion.ui.creator;

import java.util.Map;

/**
 * Created by Chaz on 5/29/2017.
 */

public class PointBuyBank {
    private int startingFunds;
    private int funds;
    private Map<Integer, Integer> costs;

    public PointBuyBank(int funds, Map<Integer, Integer> costMap)
    {

        this.startingFunds = this.funds = funds;
        this.costs = costMap;
    }

    public boolean canAfford(int score)
    {
        return costs.containsKey(score) && costs.get(score) <= funds;
    }

    public boolean refund(int score)
    {
        if(costs.containsKey(score))
        {
            funds += costs.get(score);
            return true;
        }
        return false;
    }

    public boolean purchase(int score)
    {
        if(canAfford(score))
        {
            funds -= costs.get(score);
            return true;
        }
        return false;
    }

    public void reset()
    {
        funds = startingFunds;
    }

    public int getBalance()
    {
        return funds;
    }
}
