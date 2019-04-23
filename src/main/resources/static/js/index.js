

function  MyEncrypt(a) {

    // 密钥 16 位
    var key = '31323334353637383930414243444546';
    // 初始向量 initial vector 16 位
    var iv = '30313233343536373839414243444546';//这是转成16进制之后的数据
    // key 和 iv 可以一致

    var b = CryptoJS.enc.Hex.parse(key);
    var vi = CryptoJS.enc.Hex.parse(iv);
    var encrypted = CryptoJS.AES.encrypt(a, b, {
        iv: vi,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });
    encrypted = encrypted.ciphertext.toString();
    return encrypted;
}

//aes解密
function MyDecrypt(a) {

    // 密钥 16 位,这是byte转成16进制之后的数据
    var key = '31323334353637383930414243444546';
    // 初始向量 initial vector 16 位,这是byte转成16进制之后的数据
    var iv = '30313233343536373839414243444546';
    // key 和 iv 可以一致

     var  b = CryptoJS.enc.Hex.parse(key);
     var  vi = CryptoJS.enc.Hex.parse(iv);
     a = CryptoJS.enc.Hex.parse(a);
     a = CryptoJS.enc.Base64.stringify(a);
    var decrypted = CryptoJS.AES.decrypt(a, b,{
        iv:vi,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });
    decrypted = CryptoJS.enc.Utf8.stringify(decrypted);
    return decrypted;
}