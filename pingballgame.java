<head>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div id="game">
        <div id="skate"></div>
        <div id="rock"></div>
    </div>
    <h1 id="score">0</h1>
    </div>
    <div>
        <button id="new-game">New Game </button>
    </div>
</body>

<script>
    const skate = document.getElementById("skate");
    const rock = document.getElementById("rock");
    const score = document.getElementById("score");
    const newGameButton = document.getElementById("new-game");

    function jump() {
        skate.classList.add("jump-animation");
        setTimeout(() => skate.classList.remove("jump-animation"), 500);
    }

    document.addEventListener('keypress', (event) => {
        if (!skate.classList.contains('jump-animation')) {
            jump();
        }
    });


    let animationId;
    newGameButton.addEventListener('click', () => {
        resetScore();
        resetRockAnimation();
        playScoreAnimation();


        function resetScore() {
            clearInterval(animationId);
            score.innerText = 0;
        }
        function resetRockAnimation() {
            rock.classList = [];
            setTimeout(() => rock.classList.add('rock-animation'), 0);
        }
        function playScoreAnimation() {
            animationId = setInterval(() => {
                const skateTop = parseInt(window.getComputedStyle(skate).getPropertyValue('top'));
                const rockLeft = parseInt(window.getComputedStyle(rock).getPropertyValue('left'));
                score.innerText++;

                if (rockLeft < 0) {
                    rock.style.display = 'none';
                }
                else {
                    rock.style.display = '';
                }

                if (rockLeft < 50 && rockLeft > 0 && skateTop > 150) {
                    clearInterval(animationId);
                }
            }, 50);
        }
    });
</script>


#score {
    text-align: center;
}

#game {
    width: 600px;
    height: 300px;
    border: 2px solid black;
    margin: auto;
    background-image: url("./background.gif");
    background-size: cover;
}

#skate {
    height: 75px;
    width: 75px;
    top: 225px;
    position: relative;
    background-image: url("./skateboard.png");
    background-size: cover;

    background-color: slategrey;
}

#rock {
    width: 50px;
    height: 50px;
    position: relative;
    top: 175px;
    left: 550px;
    background-image: url("./rock.png");
    background-size: cover;

    background-color: lightcoral ;
}

.rock-animation {
    animation: rock 1.33s infinite;
}

@keyframes rock {
    0% {
        left: 550px;
    }

    100% {
        left: -50px;
    }
}

.jump-animation {
    animation: jump 0.5s;
}

@keyframes jump {
    0% {
        top: 225px;
    }

    50% {
        top: 75px;
    }

    75% {
        top: 75px;
    }

    100% {
        top: 225px;
    }
}


