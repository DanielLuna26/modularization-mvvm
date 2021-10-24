package com.softmoon.common

import java.io.IOException

class UnauthorizedException( message: String ) : IOException(message)
class NoInternetException( message: String ) : IOException(message)