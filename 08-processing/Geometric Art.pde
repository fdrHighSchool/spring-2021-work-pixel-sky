class Point {
	constructor(x, y){
		this.x = x;
		this.y = y;
	}
}
const LAYERS = 5;
var layers = 1;

var SIZE;
var TOPPOINT;
var LEFTPOINT;
var RIGHTPOINT;

var callStack = [];

function setup() {
	SIZE = windowHeight * 0.9;
	let mid = windowWidth / 2;
	TOPPOINT = new Point(mid, windowHeight * 0.05);
	LEFTPOINT = new Point(mid - (SIZE / Math.sqrt(3)), windowHeight * 0.95);
	RIGHTPOINT = new Point(mid + (SIZE / Math.sqrt(3)), windowHeight * 0.95);
	
	createCanvas(windowWidth, windowHeight);
	background(0, 80, 107);
	noFill();
}

function subDivide(topPoint, leftPoint, rightPoint) {
	let virticalMid = (topPoint.y + leftPoint.y) / 2;
	let new_leftPoint = new Point((leftPoint.x + topPoint.x) / 2, virticalMid);
	let new_rightPoint = new Point((topPoint.x + rightPoint.x) / 2, virticalMid);
	let new_bottomPoint = new Point((leftPoint.x + rightPoint.x) / 2, leftPoint.y);
	triangle(new_leftPoint.x, new_leftPoint.y, new_rightPoint.x, new_rightPoint.y, new_bottomPoint.x, new_bottomPoint.y);
	return [wrapper(topPoint, new_leftPoint, new_rightPoint), 
					wrapper(new_leftPoint, leftPoint, new_bottomPoint), 
					wrapper(new_rightPoint, new_bottomPoint, rightPoint)]
}

function wrapper(topPoint, leftPoint, rightPoint) {
	return function() {
		return subDivide(topPoint, leftPoint, rightPoint);
	}
}

function draw() {
	triangle(TOPPOINT.x, TOPPOINT.y, LEFTPOINT.x, LEFTPOINT.y, RIGHTPOINT.x, RIGHTPOINT.y);
	callStack.push(subDivide(TOPPOINT, LEFTPOINT, RIGHTPOINT));	
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

