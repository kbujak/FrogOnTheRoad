package pl.edu.pk.frogOnTheRoad.board;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import pl.edu.pk.frogOnTheRoad.sprite.Obstacle;


public class Facade {
	
	private int count = 2;
    private FactoryObstacle factory = new FactoryObstacle();
    private Random rand = new Random();
    private boolean continued;
    private Obstacle tryThisOne, theOldOne;
    private Rectangle RtheOldOne;
    

	public void prepareForLevel(int level, ArrayList<Obstacle> obstacles, int flag) {

		int checkedForIntersection =0;
		
		if((level+1)%2 == 0 && flag == 0)
    		Board.speed +=3;
    	
        if(level % 2 == 0 && flag == 0){
        	
        	count++;
        }
        
        
        
        for(int howManyIsRightNow = 0 ;  howManyIsRightNow < count; howManyIsRightNow++){
        	
        	if(howManyIsRightNow == 0){
        		//wzorzed projektowy fabryka
        		obstacles.add((Obstacle)factory.create(1*rand.nextInt(900),
            			220 + 100*rand.nextInt(4),
            			rand.nextInt(4)));
        	}

        	
        	
        	else{
        		tryThisOne = (Obstacle)factory.create(1*rand.nextInt(900),
            			220 + 100*rand.nextInt(4),
            			rand.nextInt(4));
        		
        		Rectangle RtryThisOne = tryThisOne.getBounds();
        		
        		while(checkedForIntersection < howManyIsRightNow )
        		{

        			theOldOne = obstacles.get(checkedForIntersection);
            		RtheOldOne  = theOldOne.getBounds();
            		
            		if(RtryThisOne.intersects(RtheOldOne)){
            			//jeœli koliduj¹ trzeba wylosowaæ nowego

            			tryThisOne = (Obstacle)factory.create(1*rand.nextInt(900),
                    			220 + 100*rand.nextInt(4),
                    			rand.nextInt(4));
            			
            			RtryThisOne = tryThisOne.getBounds();
            			
            			//i sprawdzaæ od nowa
            			checkedForIntersection = 0;         			
            			
            		}
            		
            		else{
            			//nie koliduj¹
            			checkedForIntersection += 1; 
            			
            		}
        		}
        		
        		//mo¿na go dodaæ
        		obstacles.add(tryThisOne);
        		checkedForIntersection = 0;

        	}

    }
		
	}




}
