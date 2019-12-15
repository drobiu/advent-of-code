let fs = require('fs');
let input = fs.readFileSync('data_5.txt', 'utf8').split(',');
for (var j = 0; j < input.length; j++) 
    input[j] = parseInt(input[j]);

let i = 0;

while (input[i] != 99) {
    let instruction = input[i];
    let opcode = instruction % 100;
    instruction = Math.floor(instruction /= 100);

    let params = [];
    let point = 0;   
    while (point < 3) {
        params[point] = instruction % 10;
        instruction = Math.floor(instruction /= 10);
        point++;
    }

    let param1 = params[0] == 0 ? input[input[i+1]] : input[i+1];
    let param2 = params[1] == 0 ? input[input[i+2]] : input[i+2];
    let param3 = params[2] == 0 ? input[i+3] : i+3;

    switch(opcode) {
        case 1:
            input[param3] = param1 + param2;
            i += 4;
            break;
        case 2:
            input[param3] = param1 * param2;
            i += 4;
            break;
        case 3:
            let param4 = params[0] == 0 ? input[i+1] : i+1;
            input[param4] = 5;
            i += 2;
            break;
        case 4:
            console.log(params[0] == 0 ? input[input[i+1]] : input[i+1]);
            i += 2;
            break;
        case 5:
            i = param1 != 0 ? param2 : i + 3;
            break;
        case 6:
            i = param1 == 0 ? param2 : i + 3;
            break;
        case 7:
            input[param3] = param1 < param2 ? 1 : 0;
            i += 4;
            break;
        case 8:
            input[param3] = param1 == param2 ? 1 : 0;
            i += 4;
            break;
    }  
}
