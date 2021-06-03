const SQRT3 = Math.sqrt(3);

const LAYERS = 5;
var layers = 1;

var callStack = [];

function setup() {
	createCanvas(windowWidth, windowHeight);
	background(0, 80, 107);
	noFill();
	
	let radius = (windowHeight * 0.9) / 3;
	let centerX = windowWidth / 2;
	let centerY = (radius * 2) + (windowHeight * 0.1 / 2);
	
	triangle(centerX, centerY-(radius*2), centerX+(radius*SQRT3), centerY+radius, centerX-(radius*SQRT3), centerY+radius);
	callStack.push(subDivide(centerX, centerY, radius));	
}

function subDivide(centerX, centerY, radius) {
	let h = radius / 2;
	let h_shift = h * SQRT3;
	triangle(centerX-h_shift, centerY-h, centerX+h_shift, centerY-h, centerX, centerY+radius);
	return [wrapper(centerX, centerY-radius, h), 
			wrapper(centerX+h_shift, centerY+h, h), 
			wrapper(centerX-h_shift, centerY+h, h)]
}

function wrapper(centerX, centerY, radius) {
	return function() {
		return subDivide(centerX, centerY, radius);
	}
}

function draw() {
	while (layers < LAYERS) {
		let len = callStack.length;
		for (let i = 0; i < len; i++) {
			for (let func = 0; func < callStack[i].length; func++) {
				let t = callStack[i][func]();
				if (i >= len - Math.pow(3, layers)) 
					callStack.push(t);		
			}
		}
		layers++
	}
}