const LAYERS = 10;
var layers = 1;

var SIZE;
var MID;

var callStack = [];

function setup() {
	SIZE = windowHeight * 0.9;
	MID = windowWidth / 2;
	
	createCanvas(windowWidth, windowHeight);
	background(0, 80, 107);
	noFill();
	triangle(MID, windowHeight * 0.05, MID - (SIZE / Math.sqrt(3)), windowHeight * 0.95, MID + (SIZE / Math.sqrt(3)), windowHeight * 0.95);
	callStack.push(subDivide(MID, windowHeight * 0.05, MID - (SIZE / Math.sqrt(3)), windowHeight * 0.95, MID + (SIZE / Math.sqrt(3)), windowHeight * 0.95));	
}

function subDivide(tx, ty, lx, ly, rx, ry) {
	let virticalMid = (ty + ly) / 2;
	let n_lx = (lx + tx) / 2;
	// let ly = virticalMid;
	let n_rx = (tx + rx) / 2;
	// let ry = virticalMid;
	let n_bx = (lx + rx) / 2;
	triangle(n_lx, virticalMid, n_rx, virticalMid, n_bx, ly);
	return [wrapper(tx, ty, n_lx, virticalMid, n_rx, virticalMid), 
					wrapper(n_lx, virticalMid, lx, ly, n_bx, ly), 
					wrapper(n_rx, virticalMid, n_bx, ly, rx, ry)]
}

function wrapper(tx, ty, lx, ly, rx, ry) {
	return function() {
		return subDivide(tx, ty, lx, ly, rx, ry);
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