const SQRT3 = Math.sqrt(3);
const COLOR = "#1E8BA1";

var layers = 5;
var finalRadius;

function setup() {
	createCanvas(windowWidth, windowHeight);
	background(COLOR);
	textSize(32);
	
	start();
}

function subDivide(centerX, centerY, radius) {
	if (radius > finalRadius) {
		let h = radius / 2;
		let h_shift = h * SQRT3;
		triangle(centerX-h_shift, centerY-h, centerX+h_shift, centerY-h, centerX, centerY+radius);
		subDivide(centerX, centerY-radius, h);
		subDivide(centerX+h_shift, centerY+h, h);
		subDivide(centerX-h_shift, centerY+h, h);
	}
}

function draw() {
	
}

function start() {
	fill(31, 251, 255);
	text(`layer: ${layers}`, 30, 50);
	noFill();
	
	let radius = (windowHeight * 0.9) / 3;
	finalRadius = radius / Math.pow(2, layers);
	let centerX = windowWidth / 2;
	let centerY = (radius * 2) + (windowHeight * 0.1 / 2);
	
	triangle(centerX, centerY-(radius*2), centerX+(radius*SQRT3), centerY+radius, centerX-(radius*SQRT3), centerY+radius);
	subDivide(centerX, centerY, radius);
}

function keyPressed() {
	if (keyCode === UP_ARROW) {
		background(COLOR);
		layers++;		
		start();
	} else if (keyCode === DOWN_ARROW) {
		background(COLOR);
		if (layers > 0) 
			layers--;
		start();
	} 
}
