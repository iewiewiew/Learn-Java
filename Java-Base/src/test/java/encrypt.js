const jsencrypt = require("./jsencrypt");

const JSEncrypt = jsencrypt.JSEncrypt;
// print(Duktape.enc('jx', JSEncrypt));

const jse = new JSEncrypt();
// print(Duktape.enc('jx', jse));

jse.setPublicKey(publicKey);

result = jse.encrypt(csrfToken + separator + password);
console.log(result)
