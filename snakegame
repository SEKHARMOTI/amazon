def button(msg,x,y,w,h,ic,ac, action=None, arg = None):
  mouse = pygame.mouse.get_pos()
  click = pygame.mouse.get_pressed()

  pygame.draw.rect(win, ic, (x,y,w,h))
    #print(mouse)
  if x + w > mouse[0] > x and y+h > mouse[1] > y:
    pygame.draw.rect(win, ac, (x,y,w,h))
    if click[0] == 1 and action != None:
      if arg:
         action(arg)
      else:
         action()
  else:
    pygame.draw.rect(win, ic, (x,y,w,h))
  smallText = pygame.font.Font("Gameplay.ttf", 20)
  textSurf, textRect = text_objects(msg, smallText)
  textRect.center = ((x+(w/2), y+(h/2)))
  win.blit(textSurf, textRect)

def collect_items(obj):
  button("YES",150,450,100,50,green, bright_green, remove_image,obj)
  button("NO",550,450,100, 50, red, bright_red)
  message_display('Do you want to pick up item?')

def remove_image(obj):
    del objs[objs.index(obj)]


import time
import sys
import pygame
#we need to initiate pygame at the start of all our code
pygame.init()
display_width = 800
display_height = 600

#creating window, in tuple is width and height of screen
win = pygame.display.set_mode((display_width, display_height))

x = (display_width * 0.45)
y = (display_height * 0.8)

black = (0,0,0)
white = (255,255,255)
red = (200,0,0)
green = (0,200,0)
bright_red = (255, 0, 0)
bright_green = (0,255,0)
purple = (183,52,235)
pink = (255, 209, 237)
blue = (184, 243, 255)
bright_blue = (120, 232, 255)
bright_pink = (247, 148, 208)
transparent = (0, 0, 0, 0)

#allows us to change our fps in the game
clock = pygame.time.Clock()

swordIMG = pygame.Surface((40,40))
swordIMG.fill((255,0,0))

staffIMG = swordIMG

chestIMG = swordIMG

coinIMG = swordIMG

#good idea to create a screen width variable
screenWidth = 800

#Name of our window
pygame.display.set_caption("First Game")

#Code for importing multiple images of the animated sprite

img = pygame.Surface((50,50))
img.fill((0,255,0))

#walk right animation
walkRight = [img, img, img]

#walk left animation
walkLeft = walkRight

#back ground image load in
bg = pygame.Surface((800,800))
bg.fill((255,255,255))

#Basic standing sprite, it is the still image. shows this character when they are not moving
char = pygame.Surface((50,50))
char.fill((0,255,0))

#velocity is how fast the character moves
vel = 5

left = False
right = False
walkCount = 0 

#creating character
x = 60
y = 450
#width and height of sprite
width = 100 
height = 100

#staff
staffwidth = 94
staffheight = 106

#coin
coinwidth = 74
coinheight = 74

#chest
chestwidth = 84
chestheight = 84

class Object:
    def __init__(self, x, y, image):
        self.x = x
        self.y = y
        self.image = image
        self.rect = image.get_rect()
        self.rect.topleft = (self.x, self.y)

objs = []
objs.append(Object(600, 400, swordIMG))
objs.append(Object(70, 60, staffIMG))
objs.append(Object(600, 100, chestIMG))
objs.append(Object(350, 300, coinIMG))

can_pickup = True
prev_frame_over_Object = False


def crash():
    message_display('Item collected')

#button
def button(msg,x,y,w,h,ic,ac, action=None, arg=None):
    mouse = pygame.mouse.get_pos()
    click = pygame.mouse.get_pressed()
    pygame.draw.rect(win, ic, (x,y,w,h))
    #print(mouse)
    if x + w > mouse[0] > x and y+h > mouse[1] > y:
        pygame.draw.rect(win, ac, (x,y,w,h))
        if click[0] == 1 and action != None:
            if arg:
                action(arg)
            else:
                action()

    else:
        pygame.draw.rect(win, ic, (x,y,w,h))
        smallText = pygame.font.Font(pygame.font.match_font('calibri'), 20)
        textSurf, textRect = text_objects(msg, smallText)
        textRect.center = ((x+(w/2), y+(h/2)))
        win.blit(textSurf, textRect)

def NO():
    global can_pickup
    can_pickup = False


def collect_item(obj):

    button("YES",150,450,100,50,green, bright_green, remove_image, obj)
    message_display('Do you want to pick up item?')
    button("NO",550,450,100, 50, red, bright_red, NO)


def puff(x,y):
    win.blit(char (x,y))

def text_objects(text, font):
    textSurface = font.render(text, True, black)
    return textSurface, textSurface.get_rect()

def message_display(text):
    largeText = pygame.font.Font('freesansbold.ttf', 115)
    TextSurf, TextRect = text_objects(text, largeText)
    TextRect.center = ((display_width/2)), ((display_height/2))
    win.blit(TextSurf, TextRect)

def quitgame():
    pygame.quit()
    quit()

def game_intro():
    intro = True
    while intro:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        win.fill(white)
        largeText = pygame.font.Font(pygame.font.match_font('calibri'), 115)
        TextSurf, TextRect = text_objects("Title", largeText)
        TextRect.center = ((display_width/2)), ((display_height/2))
        win.blit(TextSurf, TextRect)

        #Button
        button("GO!",150,450,100,50, blue, bright_blue, game_loop)
        button("Quit",550,450,100, 50, pink, bright_pink, quitgame)
        pygame.display.update()


def remove_image(obj):
    del objs[objs.index(obj)]

#function which redraws the game window, this area is for drawing, we do not draw in main loop
def redrawGameWindow():
    global walkCount
    win.blit(bg, (0,0)) #back ground image
    for obj in objs:
        win.blit(obj.image, obj.rect)

    if walkCount + 1 >= 0:
        walkCount = 0

    if left:
        win.blit(walkLeft[walkCount], (x,y)) #displaying walk left sprite
        walkCount += 1

    elif right:
        win.blit(walkRight[walkCount], (x,y))
        walkCount += 1
    #repeat for up and down
    else:
        win.blit(char, (x,y)) #if we are not moving we blit our character



def game_loop(): 
    global x, y, left, right, up, down, walkCount, prev_frame_over_Object, can_pickup

    x_change = 0

    dodged = 0

    run = True

    while run:

        #redrawGameWindow()
        #game_intro()
        clock.tick(27) #sets fps to 20 seconds
        #pygame.time.delay(100) #clock in pgyame, parameter is milliseconds

        for event in pygame.event.get(): #event is what player does eg. mouse click or key press
            if event.type == pygame.QUIT: #if they click the x button (quit)
                run = False #loop = false

        #using arrow keys to move shape
        # all of the and's mean the shape cannot move off the screen
        keys = pygame.key.get_pressed()

        if keys[pygame.K_LEFT] and x > vel:
            x -= vel
            left = True
            right = False

        elif keys[pygame.K_RIGHT] and x < 800 - width - vel: #screen width - width of character
            x += vel
            right = True
            left = False

        elif keys[pygame.K_UP] and y > vel:
            y -= vel
            up = True
            down = False

        elif keys[pygame.K_DOWN] and y <  600 - height - vel:
            y += vel
            down = True
            up = False

        else:
            right = False
            left = False
            up = False
            down = False
            walkCount = 0

        redrawGameWindow()     

        is_over = False

        for obj in reversed(objs): #if delete obj in list while looping through it, the loop will still try to get the deleted obj, so reverse to fix this
            if obj.rect.collidepoint((x + vel, y + vel)):
                is_over = True
                if prev_frame_over_Object == False:
                    can_pickup = True
                if can_pickup:
                    collect_item(obj) #give the object so we know which one to delete

        prev_frame_over_Object = is_over
        pygame.display.update() #if we want something to show on the screen in pygame, we must update the screen

game_intro()
pygame.quit #game ends```}




