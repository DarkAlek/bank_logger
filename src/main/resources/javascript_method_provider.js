"use strict";

function _instanceof(left, right) { if (right != null && typeof Symbol !== "undefined" && right[Symbol.hasInstance]) { return right[Symbol.hasInstance](left); } else { return left instanceof right; } }

function _classCallCheck(instance, Constructor) { if (!_instanceof(instance, Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

// Crypto section
var g = {
  hex: "0123456789abcdef",
  ascii: "\0\x01\x02\x03\x04\x05\x06\x07\b\t\n\x0B\f\r\x0E\x0F\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x1A\x1B\x1C\x1D\x1E\x1F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\x7F\x80\x81\x82\x83\x84\x85\x86\x87\x88\x89\x8A\x8B\x8C\x8D\x8E\x8F\x90\x91\x92\x93\x94\x95\x96\x97\x98\x99\x9A\x9B\x9C\x9D\x9E\x9F\xA0\xA1\xA2\xA3\xA4\xA5\xA6\xA7\xA8\xA9\xAA\xAB\xAC\xAD\xAE\xAF\xB0\xB1\xB2\xB3\xB4\xB5\xB6\xB7\xB8\xB9\xBA\xBB\xBC\xBD\xBE\xBF\xC0\xC1\xC2\xC3\xC4\xC5\xC6\xC7\xC8\xC9\xCA\xCB\xCC\xCD\xCE\xCF\xD0\xD1\xD2\xD3\xD4\xD5\xD6\xD7\xD8\xD9\xDA\xDB\xDC\xDD\xDE\xDF\xE0\xE1\xE2\xE3\xE4\xE5\xE6\xE7\xE8\xE9\xEA\xEB\xEC\xED\xEE\xEF\xF0\xF1\xF2\xF3\xF4\xF5\xF6\xF7\xF8\xF9\xFA\xFB\xFC\xFD\xFE\xFF",
  ascii_table: {
    0: 48,
    1: 49,
    2: 50,
    3: 51,
    4: 52,
    5: 53,
    6: 54,
    7: 55,
    8: 56,
    9: 57,
    "\0": 0,
    "\x01": 1,
    "\x02": 2,
    "\x03": 3,
    "\x04": 4,
    "\x05": 5,
    "\x06": 6,
    "\x07": 7,
    "\b": 8,
    "\t": 9,
    "\n": 10,
    "\v": 11,
    "\f": 12,
    "\r": 13,
    "\x0E": 14,
    "\x0F": 15,
    "\x10": 16,
    "\x11": 17,
    "\x12": 18,
    "\x13": 19,
    "\x14": 20,
    "\x15": 21,
    "\x16": 22,
    "\x17": 23,
    "\x18": 24,
    "\x19": 25,
    "\x1A": 26,
    "\x1B": 27,
    "\x1C": 28,
    "\x1D": 29,
    "\x1E": 30,
    "\x1F": 31,
    " ": 32,
    "!": 33,
    '"': 34,
    "#": 35,
    $: 36,
    "%": 37,
    "&": 38,
    "'": 39,
    "(": 40,
    ")": 41,
    "*": 42,
    "+": 43,
    ",": 44,
    "-": 45,
    ".": 46,
    "/": 47,
    ":": 58,
    ";": 59,
    "<": 60,
    "=": 61,
    ">": 62,
    "?": 63,
    "@": 64,
    A: 65,
    B: 66,
    C: 67,
    D: 68,
    E: 69,
    F: 70,
    G: 71,
    H: 72,
    I: 73,
    J: 74,
    K: 75,
    L: 76,
    M: 77,
    N: 78,
    O: 79,
    P: 80,
    Q: 81,
    R: 82,
    S: 83,
    T: 84,
    U: 85,
    V: 86,
    W: 87,
    X: 88,
    Y: 89,
    Z: 90,
    "[": 91,
    "\\": 92,
    "]": 93,
    "^": 94,
    _: 95,
    "`": 96,
    a: 97,
    b: 98,
    c: 99,
    d: 100,
    e: 101,
    f: 102,
    g: 103,
    h: 104,
    i: 105,
    j: 106,
    k: 107,
    l: 108,
    m: 109,
    n: 110,
    o: 111,
    p: 112,
    q: 113,
    r: 114,
    s: 115,
    t: 116,
    u: 117,
    v: 118,
    w: 119,
    x: 120,
    y: 121,
    z: 122,
    "{": 123,
    "|": 124,
    "}": 125,
    "~": 126,
    "\x7F": 127,
    "\x80": 128,
    "\x81": 129,
    "\x82": 130,
    "\x83": 131,
    "\x84": 132,
    "\x85": 133,
    "\x86": 134,
    "\x87": 135,
    "\x88": 136,
    "\x89": 137,
    "\x8A": 138,
    "\x8B": 139,
    "\x8C": 140,
    "\x8D": 141,
    "\x8E": 142,
    "\x8F": 143,
    "\x90": 144,
    "\x91": 145,
    "\x92": 146,
    "\x93": 147,
    "\x94": 148,
    "\x95": 149,
    "\x96": 150,
    "\x97": 151,
    "\x98": 152,
    "\x99": 153,
    "\x9A": 154,
    "\x9B": 155,
    "\x9C": 156,
    "\x9D": 157,
    "\x9E": 158,
    "\x9F": 159,
    "\xA0": 160,
    "\xA1": 161,
    "\xA2": 162,
    "\xA3": 163,
    "\xA4": 164,
    "\xA5": 165,
    "\xA6": 166,
    "\xA7": 167,
    "\xA8": 168,
    "\xA9": 169,
    "\xAA": 170,
    "\xAB": 171,
    "\xAC": 172,
    "\xAD": 173,
    "\xAE": 174,
    "\xAF": 175,
    "\xB0": 176,
    "\xB1": 177,
    "\xB2": 178,
    "\xB3": 179,
    "\xB4": 180,
    "\xB5": 181,
    "\xB6": 182,
    "\xB7": 183,
    "\xB8": 184,
    "\xB9": 185,
    "\xBA": 186,
    "\xBB": 187,
    "\xBC": 188,
    "\xBD": 189,
    "\xBE": 190,
    "\xBF": 191,
    "\xC0": 192,
    "\xC1": 193,
    "\xC2": 194,
    "\xC3": 195,
    "\xC4": 196,
    "\xC5": 197,
    "\xC6": 198,
    "\xC7": 199,
    "\xC8": 200,
    "\xC9": 201,
    "\xCA": 202,
    "\xCB": 203,
    "\xCC": 204,
    "\xCD": 205,
    "\xCE": 206,
    "\xCF": 207,
    "\xD0": 208,
    "\xD1": 209,
    "\xD2": 210,
    "\xD3": 211,
    "\xD4": 212,
    "\xD5": 213,
    "\xD6": 214,
    "\xD7": 215,
    "\xD8": 216,
    "\xD9": 217,
    "\xDA": 218,
    "\xDB": 219,
    "\xDC": 220,
    "\xDD": 221,
    "\xDE": 222,
    "\xDF": 223,
    "\xE0": 224,
    "\xE1": 225,
    "\xE2": 226,
    "\xE3": 227,
    "\xE4": 228,
    "\xE5": 229,
    "\xE6": 230,
    "\xE7": 231,
    "\xE8": 232,
    "\xE9": 233,
    "\xEA": 234,
    "\xEB": 235,
    "\xEC": 236,
    "\xED": 237,
    "\xEE": 238,
    "\xEF": 239,
    "\xF0": 240,
    "\xF1": 241,
    "\xF2": 242,
    "\xF3": 243,
    "\xF4": 244,
    "\xF5": 245,
    "\xF6": 246,
    "\xF7": 247,
    "\xF8": 248,
    "\xF9": 249,
    "\xFA": 250,
    "\xFB": 251,
    "\xFC": 252,
    "\xFD": 253,
    "\xFE": 254,
    "\xFF": 255
  },
  base64: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
  _searchCharTable: function _searchCharTable(e, t) {
    for (var e = e + "", t = t + "", n = 0, i = t.length, o = 0, a = ""; o != (o = n + i >> 1);) {
      if (a = (o >>>= 0) < t.length ? t[o] : "", e == a) return o;
      e > a ? n = o : i = o;
    }

    return 0;
  },
  b2h: function b2h(e) {
    var t = this.hex + "",
        n = e >> 4 & 15,
        i = 15 & e;
    return ((n >>>= 0) < t.length ? t[n] : "0") + ((i >>>= 0) < t.length ? t[i] : "0");
  },
  b64c: function b64c(e) {
    return "+" == e || "-" == e ? 62 : "/" == e || "_" == e ? 63 : e >= "0" && e <= "9" ? +e + 52 : this._searchCharTable(e, this.base64);
  },
  charCode: function charCode(e) {
    var t = this.ascii_table;
    return 1 == e.length && e <= "\xFF" ? t[e] : this._searchCharTable(e, this.utf8);
  },
  a2b: function a2b(e) {
    var t = this.ascii_table;
    return 1 == e.length && e <= "\xFF" ? t[e] : 0;
  },
  b2a: function b2a(e) {
    var t = this.ascii + "";
    return (e >>>= 0) < t.length ? t[e] : "\0";
  },
  fromCharCode: function fromCharCode(e) {
    var t = this.ascii + "",
        n = this.utf8 + "";
    return (e >>>= 0) < t.length ? t[e] : (e >>>= 0) < n.length ? n[e] : "\0";
  },
  he: function he(e) {
    var t = "",
        n = 0,
        e = e + "";

    for (n = 0; n < e.length; n++) {
      t += this.b2h(this.a2b(e[n]));
    }

    return t;
  },
  fe: function fe(e) {
    var t = 0,
        n = 0,
        i = "",
        o = "",
        a = this.ascii + "",
        e = e + "";

    for (t = 0; t < e.length; t++) {
      1 & t ? (n = +("0x" + i + e[t]), o += (n >>>= 0) < a.length ? a[n] : "\0") : i = e[t];
    }

    return o;
  },
  oe: function oe(e) {
    return this._base64_encode(e, !1);
  },
  base64_urlencode: function base64_urlencode(e) {
    return this._base64_encode(e, !0);
  },
  _base64_encode: function _base64_encode(e, t) {
    var n = "",
        i = 0,
        o = 0,
        e = e + "",
        a = [0, 0],
        r = t ? "" : "=",
        s = this.base64 + "0123456789" + (t ? "-_" : "+/"),
        l = function l(e) {
      return (e >>>= 0) < s.length ? s[e] : "A";
    };

    for (i = 0; i < e.length; i++) {
      o = this.a2b(e[i]), i % 3 == 2 ? (o += (a[1] << 8) + (a[0] << 16), n += l(o >>> 18 & 63), n += l(o >>> 12 & 63), n += l(o >>> 6 & 63), n += l(63 & o), a = [0, 0]) : a[i % 3 & 1] = o;
    }

    return i % 3 != 0 && (o = (a[1] << 8) + (a[0] << 16), n += l(o >>> 18 & 63), n += l(o >>> 12 & 63), n += i % 3 == 2 ? l(o >>> 6 & 63) : r, n += r), n;
  },
  ue: function ue(e) {
    var e = e + "",
        t = "",
        n = [0, 0, 0, 0],
        i = 0,
        o = "",
        a = 0;

    for (0 != (3 & e.length) && (e += "="), i = 0; i < e.length && "=" != (o = e[i]); i++) {
      a = this.b64c(o), 3 == (3 & i) ? (a += (n[2] << 6) + (n[1] << 12) + (n[0] << 18), t += this.b2a(a >>> 16 & 255), t += this.b2a(a >>> 8 & 255), t += this.b2a(255 & a), n = [0, 0, 0, 0]) : n[i % 4 & 3] = a;
    }

    return (3 & i) > 1 && (a = (n[2] << 6) + (n[1] << 12) + (n[0] << 18), t += this.b2a(a >>> 16 & 255), 3 == (3 & i) && (t += this.b2a(a >>> 8 & 255))), t;
  }
};

var u =
/*#__PURE__*/
function () {
  function u(e, t, n) {
    _classCallCheck(this, u);

    // a
    // properties
    this.ne;
    this.ie;
    this.oe = "0123456789abcdefghijklmnopqrstuvwxyz";
    this.ae = [];

    for (this.ne = "0".charCodeAt(0), this.ie = 0; this.ie <= 9; ++this.ie) {
      this.ae[this.ne++] = this.ie;
    }

    for (this.ne = "a".charCodeAt(0), this.ie = 10; this.ie < 36; ++this.ie) {
      this.ae[this.ne++] = this.ie;
    }

    for (this.ne = "A".charCodeAt(0), this.ie = 10; this.ie < 36; ++this.ie) {
      this.ae[this.ne++] = this.ie;
    }

    this.DB = 28;
    this.DM = 268435455;
    this.DV = 268435456;
    this.F1 = 24;
    this.F2 = 4;
    this.FV = 4503599627370496;
    null != e && ("number" == typeof e ? this.fromNumber(e, t, n) : null == t && "string" != typeof e ? this.fromString(e, 256) : this.fromString(e, t));
  }

  _createClass(u, [{
    key: "toString",
    value: function toString(e) {
      // C
      if (this.s < 0) return "-" + this.negate().toString(e);
      var t;
      if (16 == e) t = 4;else if (8 == e) t = 3;else if (2 == e) t = 1;else if (32 == e) t = 5;else {
        if (4 != e) return this.toRadix(e);
        t = 2;
      }
      var n,
          i = (1 << t) - 1,
          o = !1,
          a = "",
          r = this.t,
          s = this.DB - r * this.DB % t;
      if (r-- > 0) for (s < this.DB && (n = this[r] >> s) > 0 && (o = !0, a = this.u(n)); r >= 0;) {
        s < t ? (n = (this[r] & (1 << s) - 1) << t - s, n |= this[--r] >> (s += this.DB - t)) : (n = this[r] >> (s -= t) & i, s <= 0 && (s += this.DB, --r)), n > 0 && (o = !0), o && (a += this.u(n));
      }
      return o ? a : "0";
    }
  }, {
    key: "fromString",
    value: function fromString(e, t) {
      // m
      var n;
      if (16 == t) n = 4;else if (8 == t) n = 3;else if (256 == t) n = 8;else if (2 == t) n = 1;else if (32 == t) n = 5;else {
        if (4 != t) return void this.fromRadix(e, t);
        n = 2;
      }
      this.t = 0, this.s = 0;

      for (var i = e.length, o = !1, r = 0; --i >= 0;) {
        var s = 8 == n ? 255 & e[i] : this.p(e, i);
        s < 0 ? "-" == e.charAt(i) && (o = !0) : (o = !1, 0 == r ? this[this.t++] = s : r + n > this.DB ? (this[this.t - 1] |= (s & (1 << this.DB - r) - 1) << r, this[this.t++] = s >> this.DB - r) : this[this.t - 1] |= s << r, (r += n) >= this.DB && (r -= this.DB));
      }

      8 == n && 0 != (128 & e[0]) && (this.s = -1, r > 0 && (this[this.t - 1] |= (1 << this.DB - r) - 1 << r)), this.clamp(), o && this.a.ZERO.subTo(this, this);
    }
  }, {
    key: "p",
    value: function p(e, t) {
      var n = this.ae[e.charCodeAt(t)];
      return null == n ? -1 : n;
    }
  }, {
    key: "clamp",
    value: function clamp() {
      // g
      for (var e = this.s & this.DM; this.t > 0 && this[this.t - 1] == e;) {
        --this.t;
      }
    }
  }, {
    key: "J",
    value: function J(e, t) {
      return e ^ t;
    }
  }, {
    key: "x",
    value: function x(e) {
      // Q
      var t = this.r();
      return this.bitwiseTo(e, this.J, t), t;
    }
  }, {
    key: "u",
    value: function u(e) {
      return this.oe.charAt(e);
    }
  }, {
    key: "bitwiseTo",
    value: function bitwiseTo(e, t, i) {
      // K
      var n = Math;
      var o,
          a,
          r = n.min(e.t, this.t);

      for (o = 0; o < r; ++o) {
        i[o] = t(this[o], e[o]);
      }

      if (e.t < this.t) {
        for (a = e.s & this.DM, o = r; o < this.t; ++o) {
          i[o] = t(this[o], a);
        }

        i.t = this.t;
      } else {
        for (a = this.s & this.DM, o = r; o < e.t; ++o) {
          i[o] = t(a, e[o]);
        }

        i.t = e.t;
      }

      i.s = t(this.s, e.s), i.clamp();
    }
  }, {
    key: "r",
    value: function r() {
      return new u(null);
    }
  }, {
    key: "modPowInt",
    value: function modPowInt(e, t) {
      // Z
      var n;
      return n = e < 256 || t.isEven() ? new R(t) : new F(t), this.exp(e, n);
    }
  }, {
    key: "isEven",
    value: function isEven() {
      // V
      return 0 == (this.t > 0 ? 1 & this[0] : this.s);
    }
  }, {
    key: "exp",
    value: function exp(e, t) {
      // q
      if (e > 4294967295 || e < 1) return a.ONE;
      var n = this.r(),
          i = this.r(),
          o = t.convert(this),
          s = this.L(e) - 1;

      for (o.copyTo(n); --s >= 0;) {
        if (t.sqrTo(n, i), (e & 1 << s) > 0) t.mulTo(i, o, n);else {
          var l = n;
          n = i, i = l;
        }
      }

      return t.revert(n);
    }
  }, {
    key: "f",
    value: function f(e) {
      var t = this.r();
      return t.fromInt(e), t;
    }
  }, {
    key: "toRadix",
    value: function toRadix(e) {
      // Y
      var n = Math;
      if (null == e && (e = 10), 0 == this.signum() || e < 2 || e > 36) return "0";
      var t = this.chunkSize(e),
          i = n.pow(e, t),
          o = this.f(i),
          a = this.r(),
          s = this.r(),
          l = "";

      for (this.divRemTo(o, a, s); a.signum() > 0;) {
        l = (i + s.intValue()).toString(e).substr(1) + l, a.divRemTo(o, a, s);
      }

      return s.intValue().toString(e) + l;
    }
  }, {
    key: "signum",
    value: function signum() {
      // $
      return this.s < 0 ? -1 : this.t <= 0 || 1 == this.t && this[0] <= 0 ? 0 : 1;
    }
  }, {
    key: "chunkSize",
    value: function chunkSize(e) {
      // x
      var n = Math;
      return n.floor(n.LN2 * this.DB / n.log(e));
    }
  }, {
    key: "fromInt",
    value: function fromInt(e) {
      // h
      this.t = 1, this.s = e < 0 ? -1 : 0, e > 0 ? this[0] = e : e < -1 ? this[0] = e + this.DV : this.t = 0;
    }
  }, {
    key: "divRemTo",
    value: function divRemTo(e, t, i) {
      // B
      var n = Math;
      var o = e.abs();

      if (!(o.t <= 0)) {
        var s = this.abs();
        if (s.t < o.t) return null != t && t.fromInt(0), void (null != i && this.copyTo(i));
        null == i && (i = r());
        var l = this.r(),
            c = this.s,
            u = e.s,
            p = this.DB - this.L(o[o.t - 1]);
        p > 0 ? (o.lShiftTo(p, l), s.lShiftTo(p, i)) : (o.copyTo(l), s.copyTo(i));
        var d = l.t,
            h = l[d - 1];

        if (0 != h) {
          var f = h * (1 << this.F1) + (d > 1 ? l[d - 2] >> this.F2 : 0),
              m = this.FV / f,
              g = (1 << this.F1) / f,
              C = 1 << this.F2,
              y = i.t,
              _ = y - d,
              v = null == t ? this.r() : t;

          for (l.dlShiftTo(_, v), i.compareTo(v) >= 0 && (i[i.t++] = 1, i.subTo(v, i)), //a.ONE.dlShiftTo(d, v),
          this.f(0).dlShiftTo(d, v), v.subTo(l, l); l.t < d;) {
            l[l.t++] = 0;
          }

          for (; --_ >= 0;) {
            var b = i[--y] == h ? this.DM : n.floor(i[y] * m + (i[y - 1] + C) * g);
            if ((i[y] += l.am(0, b, i, _, 0, d)) < b) for (l.dlShiftTo(_, v), i.subTo(v, i); i[y] < --b;) {
              i.subTo(v, i);
            }
          }

          null != t && (i.drShiftTo(d, t), c != u && a.ZERO.subTo(t, t)), i.t = d, i.clamp(), p > 0 && i.rShiftTo(p, i), c < 0 && a.ZERO.subTo(i, i);
        }
      }
    }
  }, {
    key: "abs",
    value: function abs() {
      // _
      return this.s < 0 ? this.negate() : this;
    }
  }, {
    key: "negate",
    value: function negate() {
      // y
      var e = r();
      return a.ZERO.subTo(this, e), e;
    }
  }, {
    key: "L",
    value: function L(e) {
      var t,
          n = 1;
      return 0 != (t = e >>> 16) && (e = t, n += 16), 0 != (t = e >> 8) && (e = t, n += 8), 0 != (t = e >> 4) && (e = t, n += 4), 0 != (t = e >> 2) && (e = t, n += 2), 0 != (t = e >> 1) && (e = t, n += 1), n;
    }
  }, {
    key: "lShiftTo",
    value: function lShiftTo(e, t) {
      // S
      var n = Math;
      var i,
          o = e % this.DB,
          a = this.DB - o,
          r = (1 << a) - 1,
          s = n.floor(e / this.DB),
          l = this.s << o & this.DM;

      for (i = this.t - 1; i >= 0; --i) {
        t[i + s + 1] = this[i] >> a | l, l = (this[i] & r) << o;
      }

      for (i = s - 1; i >= 0; --i) {
        t[i] = 0;
      }

      t[s] = l, t.t = this.t + s + 1, t.s = this.s, t.clamp();
    }
  }, {
    key: "dlShiftTo",
    value: function dlShiftTo(e, t) {
      // T
      var n;

      for (n = this.t - 1; n >= 0; --n) {
        t[n + e] = this[n];
      }

      for (n = e - 1; n >= 0; --n) {
        t[n] = 0;
      }

      t.t = this.t + e, t.s = this.s;
    }
  }, {
    key: "compareTo",
    value: function compareTo(e) {
      // v
      var t = this.s - e.s;
      if (0 != t) return t;
      var n = this.t;
      if (0 != (t = n - e.t)) return this.s < 0 ? -t : t;

      for (; --n >= 0;) {
        if (0 != (t = this[n] - e[n])) return t;
      }

      return 0;
    }
  }, {
    key: "subTo",
    value: function subTo(e, t) {
      // E
      var n = Math;

      for (var i = 0, o = 0, a = n.min(e.t, this.t); i < a;) {
        o += this[i] - e[i], t[i++] = o & this.DM, o >>= this.DB;
      }

      if (e.t < this.t) {
        for (o -= e.s; i < this.t;) {
          o += this[i], t[i++] = o & this.DM, o >>= this.DB;
        }

        o += this.s;
      } else {
        for (o += this.s; i < e.t;) {
          o -= e[i], t[i++] = o & this.DM, o >>= this.DB;
        }

        o -= e.s;
      }

      t.s = o < 0 ? -1 : 0, o < -1 ? t[i++] = this.DV + o : o > 0 && (t[i++] = o), t.t = i, t.clamp();
    }
  }, {
    key: "drShiftTo",
    value: function drShiftTo(e, t) {
      // w
      var n = Math;

      for (var i = e; i < this.t; ++i) {
        t[i - e] = this[i];
      }

      t.t = n.max(this.t - e, 0), t.s = this.s;
    }
  }, {
    key: "rShiftTo",
    value: function rShiftTo(e, t) {
      // S
      var n = Math;
      t.s = this.s;
      var i = n.floor(e / this.DB);
      if (i >= this.t) return void (t.t = 0);
      var o = e % this.DB,
          a = this.DB - o,
          r = (1 << o) - 1;
      t[0] = this[i] >> o;

      for (var s = i + 1; s < this.t; ++s) {
        t[s - i - 1] |= (this[s] & r) << a, t[s - i] = this[s] >> o;
      }

      o > 0 && (t[this.t - i - 1] |= (this.s & r) << a), t.t = this.t - i, t.clamp();
    }
  }, {
    key: "intValue",
    value: function intValue() {
      // e
      if (this.s < 0) {
        if (1 == this.t) return this[0] - this.DV;
        if (0 == this.t) return -1;
      } else {
        if (1 == this.t) return this[0];
        if (0 == this.t) return 0;
      }

      return (this[1] & (1 << 32 - this.DB) - 1) << this.DB | this[0];
    }
  }, {
    key: "invDigit",
    value: function invDigit() {
      // z
      if (this.t < 1) return 0;
      var e = this[0];
      if (0 == (1 & e)) return 0;
      var t = 3 & e;
      return t = t * (2 - (15 & e) * t) & 15, t = t * (2 - (255 & e) * t) & 255, t = t * (2 - ((65535 & e) * t & 65535)) & 65535, t = t * (2 - e * t % this.DV) % this.DV, t > 0 ? this.DV - t : -t;
    }
  }, {
    key: "am",
    value: function am(e, t, n, i, o, a) {
      // c
      for (var r = 16383 & t, s = t >> 14; --a >= 0;) {
        var l = 16383 & this[e],
            c = this[e++] >> 14,
            u = s * l + c * r;
        l = r * l + ((16383 & u) << 14) + n[i] + o, o = (l >> 28) + (u >> 14) + s * c, n[i++] = 268435455 & l;
      }

      return o;
    }
  }, {
    key: "copyTo",
    value: function copyTo(e) {
      // d
      for (var t = this.t - 1; t >= 0; --t) {
        e[t] = this[t];
      }

      e.t = this.t, e.s = this.s;
    }
  }, {
    key: "squareTo",
    value: function squareTo(e) {
      // O
      for (var t = this.abs(), n = e.t = 2 * t.t; --n >= 0;) {
        e[n] = 0;
      }

      for (n = 0; n < t.t - 1; ++n) {
        var i = t.am(n, t[n], e, 2 * n, 0, 1);
        (e[n + t.t] += t.am(n + 1, 2 * t[n], e, 2 * n + 1, i, t.t - n - 1)) >= t.DV && (e[n + t.t] -= t.DV, e[n + t.t + 1] = 1);
      }

      e.t > 0 && (e[e.t - 1] += t.am(n, t[n], e, 2 * n, 0, 1)), e.s = 0, e.clamp();
    }
  }, {
    key: "multiplyTo",
    value: function multiplyTo(e, t) {
      // k
      var n = this.abs(),
          i = e.abs(),
          o = n.t;

      for (t.t = o + i.t; --o >= 0;) {
        t[o] = 0;
      }

      for (o = 0; o < i.t; ++o) {
        t[o + n.t] = n.am(0, i[o], t, o, 0, n.t);
      }

      t.s = 0, t.clamp(), this.s != e.s && a.ZERO.subTo(t, t);
    }
  }]);

  return u;
}();

var R =
/*#__PURE__*/
function () {
  function R(e) {
    _classCallCheck(this, R);

    this.m = e;
  }

  _createClass(R, [{
    key: "convert",
    value: function convert(e) {
      // I
      return e.s < 0 || e.compareTo(this.m) >= 0 ? e.mod(this.m) : e;
    }
  }, {
    key: "sqrTo",
    value: function sqrTo(e, t) {
      // P
      e.squareTo(t), this.reduce(t);
    }
  }, {
    key: "reduce",
    value: function reduce(e) {
      // N
      e.divRemTo(this.m, null, e);
    }
  }, {
    key: "mulTo",
    value: function mulTo(e, t, n) {
      // M
      e.multiplyTo(t, n), this.reduce(n);
    }
  }, {
    key: "revert",
    value: function revert(e) {
      // x
      return e;
    }
  }]);

  return R;
}();

var F =
/*#__PURE__*/
function () {
  function F(e) {
    _classCallCheck(this, F);

    this.m = e, this.mp = e.invDigit(), this.mpl = 32767 & this.mp, this.mph = this.mp >> 15, this.um = (1 << e.DB - 15) - 1, this.mt2 = 2 * e.t;
  }

  _createClass(F, [{
    key: "convert",
    value: function convert(e) {
      // U
      var t = new u(null);
      return e.abs().dlShiftTo(this.m.t, t), t.divRemTo(this.m, null, t), e.s < 0 && t.compareTo(a.ZERO) > 0 && this.m.subTo(t, t), t;
    }
  }, {
    key: "sqrTo",
    value: function sqrTo(e, t) {
      // H
      e.squareTo(t), this.reduce(t);
    }
  }, {
    key: "reduce",
    value: function reduce(e) {
      // W
      for (; e.t <= this.mt2;) {
        e[e.t++] = 0;
      }

      for (var t = 0; t < this.m.t; ++t) {
        var n = 32767 & e[t],
            i = n * this.mpl + ((n * this.mph + (e[t] >> 15) * this.mpl & this.um) << 15) & e.DM;

        for (n = t + this.m.t, e[n] += this.m.am(0, i, e, t, 0, this.m.t); e[n] >= e.DV;) {
          e[n] -= e.DV, e[++n]++;
        }
      }

      e.clamp(), e.drShiftTo(this.m.t, e), e.compareTo(this.m) >= 0 && e.subTo(this.m, e);
    }
  }, {
    key: "mulTo",
    value: function mulTo(e, t, n) {
      // G
      e.multiplyTo(t, n), this.reduce(n);
    }
  }, {
    key: "revert",
    value: function revert(e) {
      // j
      var t = new u(null);
      return e.copyTo(t), this.reduce(t), t;
    }
  }]);

  return F;
}();

function o(e, t) {
  var i, o, a, r, c, h; // g = d.a

  var C = g.he(e) + "";

  var _ = C.length >> 1; //var _ = C.length >> 1;
  // var v = {
  //     0: 76068967,
  //     1: 181750573,
  //     2: 184994257,
  //     3: 128976718,
  //     4: 109196138,
  //     5: 257163480,
  //     6: 64015220,
  //     7: 214942817,
  //     8: 157005116,
  //     9: 74195732,
  //     10: 154036604,
  //     11: 264799603,
  //     12: 35949172,
  //     13: 56824444,
  //     14: 11381422,
  //     15: 165553948,
  //     16: 265841393,
  //     17: 8367956,
  //     18: 112420282,
  //     19: 85666152,
  //     20: 220970656,
  //     21: 5910848,
  //     22: 36066726,
  //     23: 259535566,
  //     24: 161162864,
  //     25: 57730876,
  //     26: 231430448,
  //     27: 114341081,
  //     28: 149257321,
  //     29: 243310082,
  //     30: 73572500,
  //     31: 29330787,
  //     32: 39396915,
  //     33: 28564387,
  //     34: 64080221,
  //     35: 161163224,
  //     36: 202944472,
  //     37: 189064186,
  //     38: 59770331,
  //     39: 46603539,
  //     40: 220250256,
  //     41: 213123224,
  //     42: 58709759,
  //     43: 246086074,
  //     44: 84149592,
  //     45: 227006270,
  //     46: 94910016,
  //     47: 51101448,
  //     48: 47209515,
  //     49: 25713809,
  //     50: 25351449,
  //     51: 134407271,
  //     52: 38235165,
  //     53: 129828138,
  //     54: 168727404,
  //     55: 26573701,
  //     56: 27528417,
  //     57: 264004467,
  //     58: 196103317,
  //     59: 223137021,
  //     60: 244483845,
  //     61: 119445842,
  //     62: 95754403,
  //     63: 244439315,
  //     64: 57871622,
  //     65: 114845530,
  //     66: 107232705,
  //     67: 265044219,
  //     68: 68744971,
  //     69: 208142402,
  //     70: 180593171,
  //     71: 7520126,
  //     72: 183796269,
  //     73: 213127103,
  //     74: 38982641,
  //     75: 88375850,
  //     76: 38150533,
  //     77: 105036637,
  //     78: 110849325,
  //     79: 187222336,
  //     80: 194681823,
  //     81: 73917003,
  //     82: 1753882,
  //     83: 263019691,
  //     84: 56422442,
  //     85: 142247813,
  //     86: 232641419,
  //     87: 198883137,
  //     88: 194077433,
  //     89: 2983204,
  //     90: 52093604,
  //     91: 164209924,
  //     92: 127285387,
  //     93: 45163293,
  //     94: 5839252,
  //     95: 188879542,
  //     96: 17410138,
  //     97: 56936308,
  //     98: 3818878,
  //     99: 122038063,
  //     100: 218414085,
  //     101: 89078215,
  //     102: 77352953,
  //     103: 13117149,
  //     104: 206145999,
  //     105: 178366477,
  //     106: 36659985,
  //     107: 223349013,
  //     108: 66111922,
  //     109: 166834231,
  //     110: 204349933,
  //     111: 207131892,
  //     112: 177589108,
  //     113: 247472300,
  //     114: 253308019,
  //     115: 81797594,
  //     116: 75538722,
  //     117: 74069235,
  //     118: 3964856,
  //     119: 21325346,
  //     120: 157664876,
  //     121: 112188962,
  //     122: 69046765,
  //     123: 19665392,
  //     124: 53767988,
  //     125: 34786515,
  //     126: 16045410,
  //     127: 68909132,
  //     128: 164739417,
  //     129: 20557209,
  //     130: 33385180,
  //     131: 265616345,
  //     132: 89907841,
  //     133: 107030743,
  //     134: 207937774,
  //     135: 255635548,
  //     136: 237883226,
  //     137: 188061532,
  //     138: 189420529,
  //     139: 105976689,
  //     140: 203267800,
  //     141: 2600878,
  //     142: 137723251,
  //     143: 98570525,
  //     144: 34342010,
  //     145: 91285833,
  //     146: 162,
  //     s: 0,
  //     t: 147
  // }


  var v = new u(t.n + "", 16); //var L = {0: 40261, t: 1, s: 0} 

  var L = new u(t.e + "", 16);
  var b = {
    i: "2b0e03021a",
    s: 20,
    b: 64,
    ce: function ce(e) {
      for (var t = (e += "\x80").length, n = t >> 6, i = 63 & t, o = "", a = 0, r = 0, l = [1732584193, 4023233417, 2562383102, 271733878, 3285377520], c = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]; 56 != i++;) {
        e += "\0", 64 == i && (n++, i = 0);
      }

      for (e += "\0\0\0\0", i = 3, t = 8 * (t - 1); i >= 0; i--) {
        e += g.b2a(t >> 8 * i & 255);
      }

      for (a = 0; a < e.length; a++) {
        r = (r << 8) + g.a2b(e[a]), 3 == (3 & a) && (c[a >> 2 & 15] = r, r = 0), 63 == (63 & a) && this._round(l, c);
      }

      for (a = 0; a < l.length; a++) {
        for (r = 3; r >= 0; r--) {
          o += g.b2a(l[a] >> 8 * r & 255);
        }
      }

      return o;
    },
    _round: function _round(e, t) {
      var n = e[0],
          i = e[1],
          o = e[2],
          a = e[3],
          r = e[4],
          s = 0,
          l = [1518500249, 1859775393, 2400959708, 3395469782],
          c = function c(e, t) {
        return t << e | t >>> 32 - e;
      },
          u = 0;

      for (s = 0; s < 80; s++) {
        s >= 16 && (t[127 & s] = c(1, t[s - 3 & 127] ^ t[s - 8 & 127] ^ t[s - 14 & 127] ^ t[s - 16 & 127])), u = c(5, n) + function (e, t, n, i) {
          return e < 20 ? t & n | ~t & i : e < 40 ? t ^ n ^ i : e < 60 ? t & n | t & i | n & i : t ^ n ^ i;
        }(s, i, o, a) + r + t[127 & s] + l[s / 20 & 3] | 0, r = a, a = o, o = c(30, i), i = n, n = u;
      }

      e[0] = e[0] + n | 0, e[1] = e[1] + i | 0, e[2] = e[2] + o | 0, e[3] = e[3] + a | 0, e[4] = e[4] + r | 0;
    } //var b = m, 

  };
  var T = 512; //T = v.bitLength() >> 3;

  var w = 0; //var w = 0;

  var A = ""; //var A = "";

  var S = b.s; //var S = b.s;

  var E = ""; //var E = f + "";

  var k = T - 2 * S - 2 - _; //var k = T - 2 * S - 2 - _;

  var O = 2 * (T - S - 1); //var O = 2 * (T - S - 1);

  var B = 1024; //var B = 2 * T;
  //var D = "3fd9311071d5a7da54b7e01c3891827c3646b931"   //var D = g.he(b.ce(p.a(32)));
  //var D = "0000000000000000000000000000000000000000";
  // random D
  var D = g.he(b.ce(l_random(32)));

  if (k < 0) return y = 1, "";

  for (w = 0; w < k; w++) {
    A += "00";
  }

  for (i = g.he(b.ce(E)) + A + "01" + C, o = s(D, T - S - 1), a = l(new u(i, 16).x(new u(o, 16))); a.length < O;) {
    a = "0" + a;
  }

  for (r = s(a, S), c = l(new u(D, 16).x(new u(r, 16))), h = l(new u(c + a, 16).modPowInt(L, v)); h.length < B;) {
    h = "0" + h;
  }

  return h;
}

function l(e) {
  return e.toString(16);
}

function s(e, t) {
  var n = "",
      i = "",
      o = 0,
      a = 0,
      r = {
    i: "2b0e03021a",
    s: 20,
    b: 64,
    ce: function ce(e) {
      for (var t = (e += "\x80").length, n = t >> 6, i = 63 & t, o = "", a = 0, r = 0, l = [1732584193, 4023233417, 2562383102, 271733878, 3285377520], c = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]; 56 != i++;) {
        e += "\0", 64 == i && (n++, i = 0);
      }

      for (e += "\0\0\0\0", i = 3, t = 8 * (t - 1); i >= 0; i--) {
        e += g.b2a(t >> 8 * i & 255);
      }

      for (a = 0; a < e.length; a++) {
        r = (r << 8) + g.a2b(e[a]), 3 == (3 & a) && (c[a >> 2 & 15] = r, r = 0), 63 == (63 & a) && this._round(l, c);
      }

      for (a = 0; a < l.length; a++) {
        for (r = 3; r >= 0; r--) {
          o += g.b2a(l[a] >> 8 * r & 255);
        }
      }

      return o;
    },
    _round: function _round(e, t) {
      var n = e[0],
          i = e[1],
          o = e[2],
          a = e[3],
          r = e[4],
          s = 0,
          l = [1518500249, 1859775393, 2400959708, 3395469782],
          c = function c(e, t) {
        return t << e | t >>> 32 - e;
      },
          u = 0;

      for (s = 0; s < 80; s++) {
        s >= 16 && (t[127 & s] = c(1, t[s - 3 & 127] ^ t[s - 8 & 127] ^ t[s - 14 & 127] ^ t[s - 16 & 127])), u = c(5, n) + function (e, t, n, i) {
          return e < 20 ? t & n | ~t & i : e < 40 ? t ^ n ^ i : e < 60 ? t & n | t & i | n & i : t ^ n ^ i;
        }(s, i, o, a) + r + t[127 & s] + l[s / 20 & 3] | 0, r = a, a = o, o = c(30, i), i = n, n = u;
      }

      e[0] = e[0] + n | 0, e[1] = e[1] + i | 0, e[2] = e[2] + o | 0, e[3] = e[3] + a | 0, e[4] = e[4] + r | 0;
    }
  },
      s = t << 1,
      l = r.s,
      c = (t / l | 0) + (t % l ? 1 : 0);

  for (o = 0; o < c; o++) {
    for (i = "", a = 0; a < 4; a++) {
      i += g.b2h(o >> 24 - 8 * a & 255);
    }

    for (i = g.he(r.ce(g.fe(e + i))), a = 0; a < i.length; a++) {
      if (n += i[a], n.length == s) return n;
    }
  }

  return n;
} // prototypes
// u.prototype.chunkSize = X,
// u.prototype.bitwiseTo = K,
// u.prototype.copyTo = d,
// u.prototype.fromInt = h,
// u.prototype.fromString = m,
// u.prototype.clamp = g,
// u.prototype.dlShiftTo = T,
// u.prototype.drShiftTo = w,
// u.prototype.lShiftTo = A,
// u.prototype.rShiftTo = S,
// u.prototype.subTo = E,
// u.prototype.multiplyTo = k,
// u.prototype.squareTo = O,
// u.prototype.divRemTo = B,
// u.prototype.invDigit = z,
// u.prototype.isEven = V,
// u.prototype.exp = q,
// u.prototype.toRadix = Y,
// u.prototype.toString = u.C;
// u.prototype.negate = y,
// u.prototype.abs = _,
// u.prototype.x = Q,
// u.prototype.compareTo = v,
// u.prototype.bitLength = b,
// u.prototype.mod = D,
// u.prototype.modPowInt = Z,
// u.prototype.signum = $,
// u.prototype.intValue = ee,
// u.prototype.xor = Q,
// end of Crypto section
// Zito section


function a(e, t) {
  var c = {
    i: "608648016503040201",
    s: 32,
    b: 64,
    key: [1116352408, 1899447441, 3049323471, 3921009573, 961987163, 1508970993, 2453635748, 2870763221, 3624381080, 310598401, 607225278, 1426881987, 1925078388, 2162078206, 2614888103, 3248222580, 3835390401, 4022224774, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, 2554220882, 2821834349, 2952996808, 3210313671, 3336571891, 3584528711, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, 2177026350, 2456956037, 2730485921, 2820302411, 3259730800, 3345764771, 3516065817, 3600352804, 4094571909, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, 2227730452, 2361852424, 2428436474, 2756734187, 3204031479, 3329325298],
    ce: function ce(e) {
      for (var e = e + "\x80", t = e.length, n = t >> 6, i = 63 & t, o = "", a = 0, r = 0, l = [1779033703, 3144134277, 1013904242, 2773480762, 1359893119, 2600822924, 528734635, 1541459225], c = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]; 56 != i++;) {
        e += "\0", 64 == i && (n++, i = 0);
      }

      for (e += "\0\0\0\0", i = 3, t = 8 * (t - 1); i >= 0; i--) {
        e += g.b2a(t >> 8 * i & 255);
      }

      for (a = 0; a < e.length; a++) {
        r = (r << 8) + g.a2b(e[a]), 3 == (3 & a) && (c[a >> 2 & 15] = r, r = 0), 63 == (63 & a) && this._round(l, c);
      }

      for (a = 0; a < l.length; a++) {
        for (r = 3; r >= 0; r--) {
          o += g.b2a(l[a] >> 8 * r & 255);
        }
      }

      return o;
    },
    _round: function _round(e, t) {
      var n = e[0],
          i = e[1],
          o = e[2],
          a = e[3],
          r = e[4],
          s = e[5],
          l = e[6],
          c = e[7],
          u = 0,
          p = 0,
          d = 0,
          h = 0;

      for (u = 0; u < 64; u++) {
        u < 16 ? h = t[15 & u] : (p = t[u + 1 & 15], d = t[u + 14 & 15], h = t[15 & u] = (p >>> 7 ^ p >>> 18 ^ p >>> 3 ^ p << 25 ^ p << 14) + (d >>> 17 ^ d >>> 19 ^ d >>> 10 ^ d << 15 ^ d << 13) + t[15 & u] + t[u + 9 & 15] | 0), h = h + c + (r >>> 6 ^ r >>> 11 ^ r >>> 25 ^ r << 26 ^ r << 21 ^ r << 7) + (l ^ r & (s ^ l)) + this.key[63 & u], c = l, l = s, s = r, r = a + h | 0, a = o, o = i, i = n, n = h + (i & o ^ a & (i ^ o)) + (i >>> 2 ^ i >>> 13 ^ i >>> 22 ^ i << 30 ^ i << 19 ^ i << 10) | 0;
      }

      e[0] = e[0] + n | 0, e[1] = e[1] + i | 0, e[2] = e[2] + o | 0, e[3] = e[3] + a | 0, e[4] = e[4] + r | 0, e[5] = e[5] + s | 0, e[6] = e[6] + l | 0, e[7] = e[7] + c | 0;
    }
  };
  var e = e + "",
      t = unescape(encodeURIComponent(t + "")),
      n = 0,
      i = c,
      o = 0,
      a = "",
      l = "";

  for (e.length > i.b && (e = i.ce(e)); e.length < i.b;) {
    e += "\0";
  }

  for (n = 0; n < e.length; n++) {
    o = g.a2b(e[n]), a += g.b2a(54 ^ o), l += g.b2a(92 ^ o);
  }

  return g.oe(i.ce(l + i.ce(a + t)));
} // end of Zito section
// Random section


function l_random(e) {
  var t = new Uint8Array(e);
  return C(t), c(t);
}

function f(e) {
  _[v_random++] ^= 255 & e, _[v_random++] ^= e >> 8 & 255, _[v_random++] ^= e >> 16 & 255, _[v_random++] ^= e >> 24 & 255, v_random >= L_random && (v_random -= L_random);
}

function m() {
  f(new Date().getTime());
}

function c(e) {
  return String.fromCharCode.apply(null, e);
}

function u_random() {
  this.i = 0, this.j = 0, this.S = [];
}

function h() {
  return new u_random();
}

function p(e) {
  var t, n, i;

  for (t = 0; t < 256; ++t) {
    this.S[t] = t;
  }

  for (n = 0, t = 0; t < 256; ++t) {
    n = n + this.S[t] + e[t % e.length] & 255, i = this.S[t], this.S[t] = this.S[n], this.S[n] = i;
  }

  this.i = 0, this.j = 0;
}

function d() {
  var e;
  return this.i = this.i + 1 & 255, this.j = this.j + this.S[this.i] & 255, e = this.S[this.i], this.S[this.i] = this.S[this.j], this.S[this.j] = e, this.S[e + this.S[this.i] & 255];
}

function g_random() {
  if (null == y_random) {
    for (m(), y_random = h(), y_random.init(_), v_random = 0; v_random < _.length; ++v_random) {
      _[v_random] = 0;
    }

    v_random = 0;
  }

  return y_random.next();
}

function C(e) {
  var t;

  for (t = 0; t < e.length; ++t) {
    e[t] = g_random();
  }
}

u_random.prototype.init = p, u_random.prototype.next = d;

var y_random = null,
    _,
    v_random,
    L_random = 256;

var s_random = Math;

if (null == _) {
  _ = [], v_random = 0;
  var b_random;

  var T = new Uint8Array(32);

  for (b_random = 0; b_random < 32; ++b_random) {
    _[v_random++] = Math.floor(Math.random() * (256))
  }

  for (; v_random < L_random;) {
    b_random = s_random.floor(65536 * s_random.random()), _[v_random++] = b_random >>> 8, _[v_random++] = 255 & b_random;
  }

  v_random = 0, m();
}

function generate_request_id() {
  return g.base64_urlencode(l_random(20));
}

function generate_seed() {
  return l_random(32);
} 
// end of Random section

var seed = generate_seed();
var param = {
  e: "9d45",
  n: "a2570e94920c047a5e0111d8357d73027afaec1d9ed86511371b4a53f1b35975ce2dcf5af3cb05cc64e0ee66128d755be281fd4fbd91fd6adc139ad999d1b95941b784c0f4d562212ccd33346f3412c11f041d91ed6afde22965c66c145662203c7fb846a34f3480a1224e021daf192c73ec020aca95cb74c5894f4c2e21ed9f1b0373f0c9b2d50091522f6311aa1a80dc4989cf0c826dd49c4ff954f39c7d04bc05746272f03a457e364c774109a85ab4212b605919942b1231d796388b9c9a50431ae2a402d8524b9162f9bdab741dddd38b87a878535cf02afad5cab01ac31a467e24bb9a9bdfb28c94069b6d2d642bb5d2462185544822a252d3f1cb40fbfaf4822d072bf7eac3a213c680042418f70bfcc40fb6643dc16d8675a3730d06e91d9135b518a371e9952e928705d4cccfdbb04c95fbc63731a40ce11957b85a0e936c7bd052a2476c1d802e467182d5191885c912d05c2b30bbf085a83640d87d73e5040558eaaf9ba37fd6ffcb40098d20c0902c71d1339005dbb44e3fac18afd899b27d83d1c95d1b3dba325926331bf8d63462a094e809e028e57c696d0b4d9dcb5930370e73c99b2670f7832ce22655a605a3140d2bbea051b29686b365ba07faf54fd86af19de271c0adaaae363127c2248a74fc8857392e697c46c231495bb53cccfc4613d0cb74f5400d8682336a7b0074eb06c9d1ad54b2d488b867"
};

// output section
// var input_data = 'Wpo3' + seed;
// var password_hash = g.oe(g.fe(o(input_data, param)));
// var request = "{\"request\":{\"password\":\"WU32aqiO45lovlcuU5xWM3QzqRPmHSkYejALRk1WqsxTDyJPtG2FzUYnWdeWfi+VAbOht+oBWWtQXGQWkZPVwFklD5n6sFuXqI64b1LdgP1qrQJjuHjEn4RC3KAX3bPU\\/vKN0DJg26WpH+u0hWf3zxq9oE9sG2RnoXIcsxarD\\/nW7bSstOMhLwatKzab5bBCiNYgukziGSEQuSfh8Fd\\/9aH8+B+4PVWpfnhWane1EjxtCIHq4QdWYXWoj6oq9rw5rMBb2eC7j3EYXN\\/xnLtx5lo3\\/y0++r+g7qyHlg4Mi7aFYshhNAXDX2PXXkBe0au08aUnuqK76tYzEi+ONroEwvRrq\\/G\\/njvsWic9mC+WRie9pf7El8RU9pGQUqmO+d43HZXiXmomhw\\/sd27eqjVbslcL\\/ZTTUC9QCxHnaz0i6Xj3VIOOo9FMA5z0Dcj7ToM2Fudj1kIHrjBMPdS4SiUWRDtkoHufsmfTdAWVG9QbhtcR+fKuxlFo0ke\\/ZDilg6vY0t+yFD6kW0YT53+OGEoNeYDsEUHf5ApKRHeqaIOtEav5YC79RDerg4k8JKfz4XDwpfXUCHiMLYoOHtqvogYYqrozdxvk\\/3f8UhKmxdmXK1FtODiECFDJ9\\/bPaDBEHtvBGeiFmNxPeWGT7GcIrzg4QCQs+nt9Mp0cvpuLkjzvBe0=\",\"flow_id\":\"customer_web_login-UHJzg8MaT6w0TqiifOg9t1MZl\",\"action\":\"OK\",\"action_token\":\"e62JA9hO9sBi9IHCvFvuXPobJ\"},\"agent\":{\"screen_width\":1855,\"app_version\":\"1.35.306.5\",\"request_id\":\"S9Y9uF0ikGbUUQLMqUyRO_j4qR4_1(4)_u(191)\"}}";
// var x_ian_zito = a(seed, request);
// var test_request_id0 = generate_request_id();
// var test_request_id1 = generate_request_id();
// console.log("Seed: " + seed);
// console.log("Password_Hash: " + password_hash);
// console.log("X-Ian-Zito: " + x_ian_zito);
// console.log("Request_Id_0: " + test_request_id0);
// console.log("Request_Id_1: " + test_request_id1); 

// functions to java

var get_password_hash = function get_password_hash(input_data) {
  input_data = input_data + seed;
  return g.oe(g.fe(o(input_data, param)));
};

var get_ian_zito = function get_ian_zito(t) {
  var e = seed;
  var c = {
    i: "608648016503040201",
    s: 32,
    b: 64,
    key: [1116352408, 1899447441, 3049323471, 3921009573, 961987163, 1508970993, 2453635748, 2870763221, 3624381080, 310598401, 607225278, 1426881987, 1925078388, 2162078206, 2614888103, 3248222580, 3835390401, 4022224774, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, 2554220882, 2821834349, 2952996808, 3210313671, 3336571891, 3584528711, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, 2177026350, 2456956037, 2730485921, 2820302411, 3259730800, 3345764771, 3516065817, 3600352804, 4094571909, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, 2227730452, 2361852424, 2428436474, 2756734187, 3204031479, 3329325298],
    ce: function ce(e) {
      for (var e = e + "\x80", t = e.length, n = t >> 6, i = 63 & t, o = "", a = 0, r = 0, l = [1779033703, 3144134277, 1013904242, 2773480762, 1359893119, 2600822924, 528734635, 1541459225], c = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]; 56 != i++;) {
        e += "\0", 64 == i && (n++, i = 0);
      }

      for (e += "\0\0\0\0", i = 3, t = 8 * (t - 1); i >= 0; i--) {
        e += g.b2a(t >> 8 * i & 255);
      }

      for (a = 0; a < e.length; a++) {
        r = (r << 8) + g.a2b(e[a]), 3 == (3 & a) && (c[a >> 2 & 15] = r, r = 0), 63 == (63 & a) && this._round(l, c);
      }

      for (a = 0; a < l.length; a++) {
        for (r = 3; r >= 0; r--) {
          o += g.b2a(l[a] >> 8 * r & 255);
        }
      }

      return o;
    },
    _round: function _round(e, t) {
      var n = e[0],
          i = e[1],
          o = e[2],
          a = e[3],
          r = e[4],
          s = e[5],
          l = e[6],
          c = e[7],
          u = 0,
          p = 0,
          d = 0,
          h = 0;

      for (u = 0; u < 64; u++) {
        u < 16 ? h = t[15 & u] : (p = t[u + 1 & 15], d = t[u + 14 & 15], h = t[15 & u] = (p >>> 7 ^ p >>> 18 ^ p >>> 3 ^ p << 25 ^ p << 14) + (d >>> 17 ^ d >>> 19 ^ d >>> 10 ^ d << 15 ^ d << 13) + t[15 & u] + t[u + 9 & 15] | 0), h = h + c + (r >>> 6 ^ r >>> 11 ^ r >>> 25 ^ r << 26 ^ r << 21 ^ r << 7) + (l ^ r & (s ^ l)) + this.key[63 & u], c = l, l = s, s = r, r = a + h | 0, a = o, o = i, i = n, n = h + (i & o ^ a & (i ^ o)) + (i >>> 2 ^ i >>> 13 ^ i >>> 22 ^ i << 30 ^ i << 19 ^ i << 10) | 0;
      }

      e[0] = e[0] + n | 0, e[1] = e[1] + i | 0, e[2] = e[2] + o | 0, e[3] = e[3] + a | 0, e[4] = e[4] + r | 0, e[5] = e[5] + s | 0, e[6] = e[6] + l | 0, e[7] = e[7] + c | 0;
    }
  };
  var e = e + "",
      t = unescape(encodeURIComponent(t + "")),
      n = 0,
      i = c,
      o = 0,
      a = "",
      l = "";

  for (e.length > i.b && (e = i.ce(e)); e.length < i.b;) {
    e += "\0";
  }

  for (n = 0; n < e.length; n++) {
    o = g.a2b(e[n]), a += g.b2a(54 ^ o), l += g.b2a(92 ^ o);
  }

  return g.oe(i.ce(l + i.ce(a + t)));
};

var get_request_id = function get_request_id(e) {
  return generate_request_id();
};