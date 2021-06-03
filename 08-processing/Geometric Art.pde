const SQRT3 = Math.sqrt(3);

const LAYERS = 15;

var finalRadius;

function setup() {
	createCanvas(windowWidth, windowHeight);
	background(0, 80, 107);
	noFill();
	
	let radius = (windowHeight * 0.9) / 3;
	finalRadius = radius / Math.pow(2, LAYERS);
	let centerX = windowWidth / 2;
	let centerY = (radius * 2) + (windowHeight * 0.1 / 2);
	
	triangle(centerX, centerY-(radius*2), centerX+(radius*SQRT3), centerY+radius, centerX-(radius*SQRT3), centerY+radius);
	subDivide(centerX, centerY, radius);	
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
