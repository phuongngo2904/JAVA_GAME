package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.Color;

import kb_inputs.KeyHandler;
import MyGame.Panel;

public class Player extends Entity{
    public Panel pn;
    public KeyHandler keyH;

    public Player(Panel p, KeyHandler kh){
        this.pn = p;
        this.keyH = kh;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed=4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player_IMG/Walking_sprites/boy_right_2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(this.keyH.upPressed==true){
            direction="up";
            y -= speed;
        }
        else if(this.keyH.downPressed==true){
            direction="down";
            y += speed;
        }
        else if(this.keyH.leftPressed==true){
            direction="left";
            x -= speed;
        }
        else if(this.keyH.rightPressed==true){
            direction="right";
            x += speed;
        }
        spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum==1) spriteNum=2;
            else if(spriteNum==2) spriteNum=1;
            spriteCounter=0;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image=null;
        switch(direction){
            case "up":
                if(spriteNum==1){
                    image=up1;
                } 
                if (spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image=down1;
                } 
                if (spriteNum==2){
                    image=down2;
                }
                break;
            case "left":
                if(spriteNum==1){
                    image=left1;
                }
                if (spriteNum==2){
                    image=left2;
                }
                break;
            case "right":
                if(spriteNum==1){
                    image=right1;
                }
                if (spriteNum==2){
                    image=right2;
                }
                break;
        }
        g2.drawImage(image, x, y, this.pn.tileSize, this.pn.tileSize, null);
    }
}
