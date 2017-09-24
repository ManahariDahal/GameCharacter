public class Archer extends GameCharacter
{

    /*
      *Archer class 
      *@param name that is the name of the character
      *@param x that is the x coordinates
      *@param y that is the y coordinates
    */
    public Archer (String name, int x, int y)
    {
        super (name, x, y);
    }
    
    
    
    /*
      *@move Archer's movement
      *@param direction that is the direction where Archer moves
      *@param distance that is the number of units the Archer can move
    */
    public void move (char direction, int distance)
    {
    
         /*
            *loop that checks if the healthpoint is less than 10 and prevent Archer's movement if healthpoint is less than 10
         */
        if (super.getHealthPoints() < 10)
        {
        }
        
        
        
        /*
            *checks the healthpoint and allows Archer to move into any direction
        */
        else if (super.getHealthPoints() >= 10)
        {
            // Archer can move only 5 units
            
            if (direction == 'N')
            {
               
                // increasing the Y position because Archer is moving to North
                if (distance > 0 && distance <= 5)
                {
                    setY(getY() + distance);
                }
                
                
                // increasing the y coordinate value by 5 units
                else if (distance > 5)
                {
                    setY(getY() + 5);
                }
                
                else
                {
                    setY(getY() + 0);
                }
            }
            
            else if (direction == 'E')
            {
            
                // increasing the X position because Archer is moving to East
                if ( distance > 0 && distance <= 5)
                {
                    setX(getX() + distance);
                }
                
                
                // increasing the value of x coordinate by 5 units
                else if (distance > 5)
                {
                    setX(getX() + 5);
                }
                
                else
                {
                    setX(getX() + 0);
                }
                
            }
            
            
            else if (direction == 'W')
            {
            
                // decreasing the X position because Archer is moving West
                if (distance > 0 && distance <= 5)
                {
                    setX(getX() - distance);
                }
                
                
                // decreasing the value of x coordinate by 5 units
                else if (distance > 5)
                {
                    setX(getX() - 5);
                }
                
                else
                {
                    setX(getX() - 0);
                }
                
            }
            
            else if (direction == 'S')
            {
                // decreasing the Y position because Archer is moving South
                if (distance > 0 && distance <= 5)
                {
                    setY(getY() - distance);
                }
                
                
                // decreasing the value of y coordinate by 5 units
                else if (distance > 5)
                {
                    setY(getY() - 5);
                }
                
                else 
                {
                    setY(getY() - 0);
                }
                
            }
            
        }
    }
    
    
    
    /*
      *attack method where Archer attacks Knight/Wizard
    */
    public boolean attack (GameCharacter target)
    {
        
        // calculating the distance by formula
        double deltax = Math.pow(target.getX() - getX() , 2);
        double deltay = Math.pow(target.getY() - getY() , 2);
        
        double distance = Math.sqrt( deltax - deltay );
        
        
        
        
        if (super.getHealthPoints() >= 10)
        {
            // If another character is withing 30 units Archer can attack and it will give 10 damage if the attack is successful
            if (distance <= 30)
            {
               // giving 10 damage to the enemy
                target.setHp ( target.getHealthPoints() - 10 );
                
                
                // if the attack is unsuccessful then it doesn't give any damage
                if (target.getHealthPoints() <= 0)
                {
                    target.setHp(0);
                    
                }
                
                
            }
            
            else
            {
                return false;
            }
        }
        
        
        
        // when target’s health points are less than 10, the target is rendered inactive
        else if (super.getHealthPoints() < 10)
        {
            return false;
        }
        
        
        return true;
    }
    
    
    
    
   /*
      *toString method that has the required information 
      *return the character's name, healthpoints, x and y coordinates       
   */ 
    public String toString()
    {
        
        //printing user's desired layout
        return "LOTR Legend: " + super.getName() + "\t, a legendary Archer " +
        "\nHealth remaining: " + super.getHealthPoints() + 
        "(x,y): " + super.getX() + "," + super.getY();
        
    }
    
    
}
